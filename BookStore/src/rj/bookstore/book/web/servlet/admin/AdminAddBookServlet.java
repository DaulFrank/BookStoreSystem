package rj.bookstore.book.web.servlet.admin;

import cn.itcast.commons.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import rj.bookstore.book.domain.Book;
import rj.bookstore.book.service.BookService;
import rj.bookstore.category.domain.Category;
import rj.bookstore.category.servlce.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.util.*;
import java.util.List;

@WebServlet(urlPatterns = "/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {

    private BookService bookService = new BookService();
    private CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 上传三步

        DiskFileItemFactory factory = new DiskFileItemFactory(15*1024,new File("F:/f/temp"));
        ServletFileUpload sfu = new ServletFileUpload(factory);

        sfu.setFileSizeMax(15*1024);

        try {
            List<FileItem> fileItemList = sfu.parseRequest(request);

            Map<String,String> map = new HashMap<>();

            for(FileItem fileItem : fileItemList) {
                if(fileItem.isFormField()) {
                    map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
                }
            }

            Book book = CommonUtils.toBean(map,Book.class);
            book.setBid(CommonUtils.uuid());

            Category category = CommonUtils.toBean(map,Category.class);
            book.setCategory(category);


            // 保存上传的文件


            String savePath = this.getServletContext().getRealPath("/book_img");

            String filename = CommonUtils.uuid() + "_" + fileItemList.get(1).getName();

            if(!filename.toLowerCase().endsWith("jpg")) {
                request.setAttribute("msg","您上传的文件不是 jpg 格式的文件!!!");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request,response);

                return;
            }

            File destFile = new File(savePath,filename);
            // 保存文件到指定目录
            fileItemList.get(1).write(destFile);

            book.setImage("book_img/" + filename);



            bookService.add(book);

            Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();

            if(image.getWidth(null) > 200 || image.getWidth(null) > 200) {
                destFile.delete();
                request.setAttribute("msg","您上传的图片超过了 200 * 200 的尺寸!!!");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request,response);
                return;
            }


            System.out.println("..................................................................");

            request.getRequestDispatcher("/AdminBookServlet?method=findAll").forward(request,response);

        } catch (Exception e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
                request.setAttribute("msg","您上传的文件超过了 15 KB!");
                request.setAttribute("categoryList",categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
