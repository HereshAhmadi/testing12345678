package com.deerpointgroup.deerpointliquorstore.Checkout;

import com.deerpointgroup.deerpointliquorstore.cart.CartService;
import com.deerpointgroup.deerpointliquorstore.user.User;
import com.deerpointgroup.deerpointliquorstore.user.UserService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    private StripeService stripeService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/cart", method=RequestMethod.GET)
    public String checkout(Model model, Principal principal){
        model.addAttribute("amount", cartService.getCartTotal((User)userService.loadUserByUsername(principal.getName())) * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        return "cart";
    }

    @PostMapping("/cart/pay")
    public String chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getParameter("stripeToken");
        Double amount = Double.parseDouble(request.getParameter("amount"));
        stripeService.chargeNewCard(token, amount);
        System.out.println("Success");
        return "success";
    }


    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "fail";
    }

}
