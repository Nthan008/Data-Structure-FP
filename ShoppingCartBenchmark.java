import java.util.*;

public class ShoppingCartBenchmark {
    private ArrayList<Item> arrayListCart;
    private LinkedList<Item> linkedListCart;
    private Set<Item> hashSetCart;


    public ShoppingCartBenchmark() {
        this.arrayListCart = new ArrayList<>();
        this.linkedListCart = new LinkedList<>();
        this.hashSetCart = new HashSet<>();
    }

    // Insertion
    public void insert(ArrayList<Item> cart, Item item, int quantity) {
        for(int i = 0; i<quantity; i++ ){
            cart.add(item);
        }
        }


    public void insert(LinkedList<Item> cart, Item item, int quantity) {
        for(int i = 0; i<quantity; i++ ){
            cart.add(item);
        }
    }

    public void insert(Set<Item> cart, Item item, int quantity) {
        for(int i = 0; i<quantity; i++ ){
            cart.add(item);
        }
    }

    // Increase quantity if the same item already exists
    public void increaseQuantity(ArrayList<Item> cart, String name, int quantity) {
        for (Item item : cart) {
            if (item.name.equals(name)) {
                for(int i = 0; i<quantity; i++ ){
                    cart.add(item);
                }
                return;
            }
        }
    }

    public void increaseQuantity(LinkedList<Item> cart, String name, int quantity) {
        for (Item item : cart) {
            if (item.name.equals(name)) {
                for(int i = 0; i<quantity; i++ ){
                    cart.add(item);
                }
                return;
            }
        }
    }

    public void delete(ArrayList<Item> cart, String name) {
        cart.removeIf(item -> item.name.equals(name));
    }

    public void delete(LinkedList<Item> cart, String name) {
        cart.removeIf(item -> item.name.equals(name));
    }

    public void delete(Set<Item> cart, String name) {
        cart.removeIf(item -> item.name.equals(name));
    }

    // Deletion based on quantity
    public void decreaseQuantity(ArrayList<Item> cart, String name, int quantity) {
        int count = 0;
        Iterator<Item> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.name.equals(name)) {
                iterator.remove();
                count++;
                if (count == quantity) {
                    break;
                }
            }
        }
    }

    public void decreaseQuantity(LinkedList<Item> cart, String name, int quantity) {
        int count = 0;
        Iterator<Item> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.name.equals(name)) {
                iterator.remove();
                count++;
                if (count == quantity) {
                    break;
                }
            }
        }
    }

    public void decreaseQuantity(Set<Item> cart, String name, int quantity) {
        int count = 0;
        Iterator<Item> iterator = cart.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.name.equals(name)) {
                iterator.remove();
                count++;
                if (count == quantity) {
                    break;
                }
            }
        }
    }


    // Remove all items from the cart
    public void clear(ArrayList<Item> cart) {
        cart.clear();
    }

    public void clear(LinkedList<Item> cart) {
        cart.clear();
    }

    public void clear(Set<Item> cart) {
        cart.clear();
    }

    // Retrieve the total price of all items in the cart
    public double getTotalPrice(ArrayList<Item> cart) {
        double totalPrice = 0.0;
        for (Item item : cart) {
            totalPrice += item.price;
        }
        return totalPrice;
    }

    public double getTotalPrice(LinkedList<Item> cart) {
        double totalPrice = 0.0;
        for (Item item : cart) {
            totalPrice += item.price;
        }
        return totalPrice;
    }

    // Retrieval
    public Item search(ArrayList<Item> cart, String name) {
        for (Item item : cart) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Item search(LinkedList<Item> cart, String name) {
        for (Item item : cart) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    // Display the cart
    public void display(ArrayList<Item> cart) {
        System.out.println("Cart Contents:");
        for (Item item : cart) {
            System.out.println(item.name + " - $" + item.price);
        }
        System.out.println("Total Items: " + cart.size());
    }

    public void display(LinkedList<Item> cart) {
        System.out.println("Cart Contents:");
        for (Item item : cart) {
            System.out.println(item.name + " - $" + item.price);
        }
        System.out.println("Total Items: " + cart.size());
    }

    public void display(Set<Item> cart) {
        System.out.println("Cart Contents:");
        for (Item item : cart) {
            System.out.println(item.name + " - $" + item.price);
        }
        System.out.println("Total Items: " + cart.size());
    }


    public void increaseQuantity(Set<Item> cart, String name, int quantity) {
        for (Item item : cart) {
            if (item.name.equals(name)) {
                for(int i = 0; i<quantity; i++ ){
                    cart.add(item);
                }
                return;
            }
        }
    }

    public double getTotalPrice(Set<Item> cart) {
        double totalPrice = 0.0;
        for (Item item : cart) {
            totalPrice += item.price;
        }
        return totalPrice;
    }

    public Item search(Set<Item> cart, String name) {
        for (Item item : cart) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }


    public void runBenchmark() {
        ShoppingCartBenchmark cartBenchmark = new ShoppingCartBenchmark();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Shopping Cart Benchmark ---");
            System.out.println("1. ArrayList");
            System.out.println("2. LinkedList");
            System.out.println("3. HashSet");
            System.out.println("0. Exit");

            System.out.print("Choose a data structure to benchmark: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    runOperationBenchmark(cartBenchmark.arrayListCart, "ArrayList");
                    break;
                case 2:
                    runOperationBenchmark(cartBenchmark.linkedListCart, "LinkedList");
                    break;
                case 3:
                    runOperationBenchmark(cartBenchmark.hashSetCart, "HashSet");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void runOperationBenchmark(ArrayList<Item> cart, String structureName) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- " + structureName + " Shopping Cart ---");
            System.out.println("1. Add item to the cart");
            System.out.println("2. Increase quantity of an item");
            System.out.println("3. Decrease quantity of an item");
            System.out.println("4. Remove item from the cart");
            System.out.println("5. Remove all items from the cart");
            System.out.println("6. Get total price of items in the cart");
            System.out.println("7. Search for an item");
            System.out.println("8. Display the shopping cart");
            System.out.println("0. Go back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            long startTime, endTime;
            double elapsedTime;
            long startSpace, endSpace;
            long spaceUsed;

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    Item item = new Item(name, price);

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    insert(cart, item,quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Item added to the cart in " + elapsedTime + " ms");
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter quantity to increase: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    increaseQuantity(cart, name, quantity);
                    endTime = System.nanoTime();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Quantity increased in " + elapsedTime + " ms");
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter quantity to decrease: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    decreaseQuantity(cart, name, quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Quantity decreased in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 4:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    delete(cart, name);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Item removed from the cart in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 5:
                    startTime = System.nanoTime();
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    clear(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("All items removed from the cart in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 6:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    double totalPrice = getTotalPrice(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Total price: $" + totalPrice);
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    System.out.println("Total price calculated in " + elapsedTime + " ms");
                    break;
                case 7:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    Item searchedItem = search(cart, name);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    if (searchedItem != null) {
                        System.out.println("Item found: " + searchedItem.name + " - " + searchedItem.price);
                    } else {
                        System.out.println("Item not found.");
                    }
                    System.out.println("Item search completed in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");

                    break;
                case 8:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    display(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Cart displayed in " + elapsedTime + " ms");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void runOperationBenchmark(LinkedList<Item> cart, String structureName) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- " + structureName + " Shopping Cart ---");
            System.out.println("1. Add item to the cart");
            System.out.println("2. Increase quantity of an item");
            System.out.println("3. Decrease quantity of an item");
            System.out.println("4. Remove item from the cart");
            System.out.println("5. Remove all items from the cart");
            System.out.println("6. Get total price of items in the cart");
            System.out.println("7. Search for an item");
            System.out.println("8. Display the shopping cart");
            System.out.println("0. Go back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            long startTime, endTime;
            double elapsedTime;
            long startSpace, endSpace;
            long spaceUsed;

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    Item item = new Item(name, price);

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    insert(cart, item,quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Item added to the cart in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter quantity to increase: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    increaseQuantity(cart, name, quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Quantity increased in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter quantity to decrease: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    decreaseQuantity(cart, name, quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Quantity decreased in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 4:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    delete(cart, name);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Item removed from the cart in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 5:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    clear(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("All items removed from the cart in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 6:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    double totalPrice = getTotalPrice(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Total price: $" + totalPrice);
                    System.out.println("Total price calculated in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 7:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    Item searchedItem = search(cart, name);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    if (searchedItem != null) {
                        System.out.println("Item found: " + searchedItem.name + " - " + searchedItem.price);
                    } else {
                        System.out.println("Item not found.");
                    }
                    System.out.println("Item search completed in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 8:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    display(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Cart displayed in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void runOperationBenchmark(Set<Item> cart, String structureName) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- " + structureName + " Shopping Cart ---");
            System.out.println("1. Add item to the cart");
            System.out.println("2. Increase quantity of an item");
            System.out.println("3. Decrease quantity of an item");
            System.out.println("4. Remove item from the cart");
            System.out.println("5. Remove all items from the cart");
            System.out.println("6. Get total price of items in the cart");
            System.out.println("7. Search for an item");
            System.out.println("8. Display the shopping cart");
            System.out.println("0. Go back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            long startTime, endTime;
            double elapsedTime;
            long startSpace, endSpace;
            long spaceUsed;

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    Item item = new Item(name, price);

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    insert(cart, item,quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Item added to the cart in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter quantity to increase: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    increaseQuantity(cart, name, quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    spaceUsed = endSpace - startSpace;
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Quantity increased in " + elapsedTime + " ms");
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter quantity to decrease: ");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    decreaseQuantity(cart, name, quantity);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Quantity decreased in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 4:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    delete(cart, name);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Item removed from the cart in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 5:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    clear(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("All items removed from the cart in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 6:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    double totalPrice = getTotalPrice(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Total price: $" + totalPrice);
                    System.out.println("Total price calculated in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 7:
                    System.out.print("Enter item name: ");
                    name = scanner.nextLine();

                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    Item searchedItem = search(cart, name);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    if (searchedItem != null) {
                        System.out.println("Item found: " + searchedItem.name + " - " + searchedItem.price);
                    } else {
                        System.out.println("Item not found.");
                    }
                    System.out.println("Item search completed in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 8:
                    startSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    startTime = System.nanoTime();
                    display(cart);
                    endTime = System.nanoTime();
                    endSpace = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                    elapsedTime = (endTime - startTime) / 1000000.0;
                    System.out.println("Cart displayed in " + elapsedTime + " ms");
                    spaceUsed = endSpace - startSpace;
                    System.out.println("Space used: " + spaceUsed + " bytes");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCartBenchmark cartBenchmark = new ShoppingCartBenchmark();
        cartBenchmark.runBenchmark();
    }
}

