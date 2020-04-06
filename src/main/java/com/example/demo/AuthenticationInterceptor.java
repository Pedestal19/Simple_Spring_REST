package com.example.demo;

import com.example.demo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("Session ID: " + request.getSession().getId());
        if(uri.endsWith("login")){

            if(!request.getSession().isNew()){
                String token = (String) request.getSession().getAttribute("token");
                System.out.println(token);

                String username = request.getParameter("username");

                if(token!=null && token.equals("randomtoken"+username)){
                    System.out.println("Valid Request");
                }
                else if(token == null){
                    request.getSession().invalidate();
                }
                else{
                    System.out.println("Invalid Request! Token Mismatch!");
                    request.setAttribute("IsValidRequest","false");
                }
            }
        }
        else if(uri.endsWith("logout")){
            if(request.getSession().isNew()){
                request.getSession().invalidate();
                System.out.println("User not logged in!!");
            }
            else{
                String username = request.getParameter("username");
                System.out.println("Session token: " + request.getSession().getAttribute("token"));
                String token = "randomtoken" + username;
                if(!token.equals(request.getSession().getAttribute("token"))){
                    System.out.println("Invalid Request");
                    return false;
                }
                else{
                    System.out.println("Valid Log Out Request");
                }
            }
        }
        else if(uri.endsWith("checkbalance")){

            String token = (String) request.getSession().getAttribute("token");
//            String token = Session.getAttribute("token");

            System.out.println("==== token is ====");
            System.out.println(token);

            String username = request.getParameter("username");
            System.out.println("==== username is ====");
            System.out.println(username);

//            System.out.println("username is ::"+username);
          /*  if(token.equals("randomtoken"+token)){
                System.out.println(true);
            }*/
            if(token == null || !token.equals("randomtoken"+username)){
                System.out.println(token);
                System.out.println("Invalid Check Balance Request");
                return false;
            }


//            if(!userRepository.findByUsername(request.getSession().getAttribute("u").toString()).isLoggedIn()){
//                System.out.println("Invalid Check Balance Request");
//                return false;
//            }
            return true;
        }
        else if(uri.endsWith("message")){

            String token = (String) request.getSession().getAttribute("token");
//            String token = Session.getAttribute("token");

            System.out.println("==== token is ====");
            System.out.println(token);

            String username = request.getParameter("username");
            System.out.println("==== username is ====");
            System.out.println(username);

//            System.out.println("username is ::"+username);
          /*  if(token.equals("randomtoken"+token)){
                System.out.println(true);
            }*/
            if(token == null){
                System.out.println(token);
                System.out.println("Invalid Check Balance Request");
                return false;
            }


//            if(!userRepository.findByUsername(request.getSession().getAttribute("u").toString()).isLoggedIn()){
//                System.out.println("Invalid Check Balance Request");
//                return false;
//            }
            return true;
        }
        else if(uri.endsWith("signup")){
            System.out.println("Redirecting to Signup Page");
        }
        return true;
    }

}
