
public class BuildOrder {

    public static IComposite getOrder() {
        Composite order = new Order();

        CustomBurger customBurger = new CustomBurger();

        String[] bo = { "Organic Bison*", "1/2lb.", "On A Bun" };
        String[] co = { "Yellow American", "Spicy Jalapeno Jack" };
        String[] pco = { "Danish Blue Cheese" };
        String[] so = { "Mayonnaise", "Thai Peanuts Sauce" };
        String[] to = { "Black Olives", "Spicy Pickles", "Dill Pickle Chips" };
        String[] pto = { "Marinated Tomatoes" };
        String[] buo = { "Ciabatta (Vegan)" };
        String[] sio = { "Shoestring Fries"};

        // Setup Custom Burger Ingredients
        customBurger.addChild(new Burger(bo));
        customBurger.addChild(new Cheese(co));
        customBurger.addChild(new PremiumCheese(pco));
        customBurger.addChild(new Sauce(so));
        customBurger.addChild(new Toppings(to));
        customBurger.addChild(new PremiumToppings(pto));
        customBurger.addChild(new Bun(buo));
        customBurger.addChild(new Sides(sio));

        // Add Custom Burger to the Order
        order.addChild(customBurger);

        customBurger = new CustomBurger();

        String[] bo2 = { "Hormone & Antibiotics Free Beef*", "1/3lb.", "On A Bun" };
        String[] co2 = { "Greek Feta", "Smoked Gouda" };
        String[] pco2 = { "Fresh Mozzarella" };
        String[] so2 = { "Habanero Salsa" };
        String[] to2 = { "Crushed Peanuts" };
        String[] pto2 = { "Marinated Tomatoes", "Sunny Side Up Egg*" };
        String[] buo2 = { "Gluten-Free Bun" };
        String[] sio2 = { "Shoestring Fries"};

        // Setup Custom Burger Ingredients
        customBurger.addChild(new Burger(bo2));
        customBurger.addChild(new Cheese(co2));
        customBurger.addChild(new PremiumCheese(pco2));
        customBurger.addChild(new Sauce(so2));
        customBurger.addChild(new Toppings(to2));
        customBurger.addChild(new PremiumToppings(pto2));
        customBurger.addChild(new Bun(buo2));
        customBurger.addChild(new Sides(sio2));

        // Add Custom Burger to the Order
        order.addChild(customBurger);

        return order;
    }

}