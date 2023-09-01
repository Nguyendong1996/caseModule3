package com.casemodule3.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IGenerateServlet {
        void disPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException;
        void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
        void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
        void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
        void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
        void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
