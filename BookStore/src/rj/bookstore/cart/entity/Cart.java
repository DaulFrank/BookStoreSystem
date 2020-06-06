package rj.bookstore.cart.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();


    public double getTotal() {
        BigDecimal total = new BigDecimal("0");
        for(CartItem cartItem : map.values()) {
            BigDecimal d2 = new BigDecimal(""+cartItem.getSubtotal());
            total = total.add(d2);
        }
        return total.doubleValue();
    }

    public void add(CartItem cartItem){
        if(map.containsKey(cartItem.getBook().getBid())) {
            CartItem _cartItem = map.get((cartItem.getBook().getBid()));
            _cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
            map.put(cartItem.getBook().getBid(),_cartItem);
        } else {
            map.put(cartItem.getBook().getBid(),cartItem);
        }
    }

    public void clear(){
        map.clear();
    }

    public void delete(String bid) {
        map.remove(bid);
    }

    public Collection<CartItem> getCartItems() {
        return map.values();
    }

}
