package com.igeek.shop.controller;

import com.google.gson.Gson;
import com.igeek.shop.pojo.Category;
import com.igeek.shop.pojo.Page;
import com.igeek.shop.pojo.Product;
import com.igeek.shop.service.ProductService;
import com.igeek.shop.service.impl.ProductServiceImpl;
import com.igeek.shop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：Allen
 * @date ：Created in 2021/1/26 15:29
 * @description：
 * @version: 1.0
 */
@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends BaseServlet {

    private ProductService productService = new ProductServiceImpl();


    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> hot = productService.viewHotTop12();
        List<Product> last = productService.viewLastTop12();
        req.setAttribute("hot", hot);
        req.setAttribute("last", last);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void showCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取所有的商品总类
        List<Category> categories = productService.viewAllCategory();
        //使用Google提供的Gson 将其以json字符串的格式响应到客户端
        Gson gson = new Gson();
        String json = gson.toJson(categories);
//        System.out.println(json);
        resp.getWriter().write(json);
    }

    /**
     * 分页 查询  商品类别 +商品名的模糊查询
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求中获取商品名称 没有的话就是""
        String pname = WebUtils.getStr(req.getParameter("pname"));
        //从请求中获取当前页号 没有就是第一页
        Integer currentPageNumber = WebUtils.parseStr2Int(
                req.getParameter("currentPageNumber"), 1);
        //从请求中获取商品种类 没有就是""
        String cname = WebUtils.getStr(req.getParameter("cname"));
        //通过商品种类 获取商品种类编号
        int cid = productService.viewCategoryByCname(cname);
        Page<Product> page = null;
        //调用productService对应的方法进行获取Page对象
        String url = null;
        if (cid == -1) {
            page = productService.pageByPname(pname, currentPageNumber, Page.DEFAULT_SIZE);
            url = "pname=" + pname;
        } else {
            page = productService.pageByCid(cid, currentPageNumber, Page.DEFAULT_SIZE);
            //将商品种类放入查询条件中
            page.getQuery().put("cname", cname);
            url = "cname=" + cname;
        }
        //设置请求地址
        page.setUrl("product?method=page&" + url);

        //将page对象存入请求域中
        req.setAttribute("page", page);
        //请求妆发到 /pages/product/product_list.jsp页面
        req.getRequestDispatcher("/pages/product/product_list.jsp").forward(req, resp);

    }

    /**
     * 展示商品的详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("pid");
        if(!WebUtils.checkRange(pid)){
            //通过地址栏瞎输
            resp.sendRedirect(req.getHeader("referer"));
            return ;
        }
        //将数据存放在请求域中
        req.setAttribute("product",productService.showDetailByPid(pid));
        //请求转发到 商品详情页
        req.getRequestDispatcher("/pages/product/product_info.jsp").forward(req,resp);
    }


}
