

1.org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
  This will activated when we using the form-login in spring security 

2.All the requests will be intercepted by this filter.

3.The authentication is going to be managed by the normal form login, 
   the only difference is that the response will be on JSON along with an HTTP 
   status which can either code 200 (if the autentication passed) or code 401 (if the authentication failed) ;
   
4.Override the AuthenticationFailureHandler to return the code 401 UNAUTHORIZED ;

5.Override the AuthenticationSuccessHandler to return the code 20 OK, the body of the HTTP response contain the JSON data of the current authenticated user ;

6.Override the AuthenticationEntryPoint to always return the code 401 UNAUTHORIZED. This will override the default behavior of Spring Security 
  which is forwarding the user to the login page if he don’t meet the security requirements, because on REST we don’t have any login page ;

7.Override the LogoutSuccessHandler to return the code 20 OK ;