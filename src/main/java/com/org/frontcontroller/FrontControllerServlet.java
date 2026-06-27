package com.org.frontcontroller;

import com.org.controller.Controller;
import com.org.controller.MemberFormController;
import com.org.controller.MemberListController;
import com.org.controller.MemberSaveController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {
    private Map<String, Controller> controllerMap = new HashMap<>();
    private ViewResolver viewResolver = new ViewResolver();
    private HandlerMapping handlerMapping = new HandlerMapping();

    // doGet이 아니라 Service로 메서드명을 쓰는 이유는 프론트 컨트롤러는 먼저 오는 모든 요청을 다 받는 입구 역할을 하기 때문이다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = requestURI.substring((contextPath.length()));

        String key = req.getMethod() + " " + path;

        Controller controller = handlerMapping.getController(key);

        if(controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println("404 Not Found");
            return;
        }

        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(req, resp, model);

        if (viewName.startsWith("redirect:")) {
            String redirectPath = viewName.substring("redirect:".length());
            resp.sendRedirect(req.getContextPath() + redirectPath);
            return;
        }

        for (String k : model.keySet()) {
            req.setAttribute(k, model.get(k));
        }

        String viewPath = viewResolver.resolve(viewName);
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }
}
