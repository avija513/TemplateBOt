import java.util.Scanner;

public class Main {

        // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
        // May want to create an array of goodbye answers.
        static String[] goodBye = { "bye", "goodbye", "nothing" };

        static Restaurant subway = new Restaurant("Subway", 10, true, "sandwiches, drinks, and cookies", 2, false,
                        "https://www.subway.com/en-us", 1.1);
        static Restaurant chipotle = new Restaurant("Chipotle", 20, true,
                        "burritos, chips, burrito bowls, and quesadillas", 5, true, "https:si//www.chipotle.com", 2.7);
        static Restaurant pandaExpress = new Restaurant("Panda Express", 14, false, "chow mein, fried rice,", 3, false,
                        "https://www.pandaexpress.com", 2.0);
        static Restaurant[] fastfood = { subway, chipotle, pandaExpress };

        static Restaurant oliveGarden = new Restaurant("Olive Garden", 30, true, "pasta, pizza, soup, salad, and bread",
                        3, false, "https://www.olivegarden.com/home", 17.8);
        static Restaurant mylapore = new Restaurant("Mylapore", 25, true, "dosa, idly, sambar, paratha, mango lassi",
                        5, true, "https://www.mylaporeexpress.com", 3.2);
        static Restaurant sultansKebab = new Restaurant("Sultan's Kebab", 20, true, "Wraps, falafel, fries, hummus", 4,
                        false, "https://sultanskebab.net", 2.7);
        static Restaurant[] sitdown = { oliveGarden, mylapore, sultansKebab };

        static Restaurant coldStone = new Restaurant("Coldstone", 6, true, "ice cream, toppings, ice cream cakes", 3,
                        false, "https://www.coldstonecreamery.com", 1.3);
        static Restaurant krispyKreme = new Restaurant("Krispy Kreme", 5, true, "Donuts", 2, false,
                        "https://www.krispykreme.com", 23.8);
        static Restaurant crumblCookies = new Restaurant("Crumbl Cookies", 6, true, "Cookies, cakes", 4, false,
                        "https://crumblcookies.com", 4.1);
        static Restaurant[] dessert = { coldStone, krispyKreme, crumblCookies };

        static int state = 0;

        public static void main(String[] args) {

                Restaurant[] result = new Restaurant[fastfood.length];
                String userRespLow = askQuestions();
                while (checkExit(userRespLow) == false) {

                        result = processResponse(result, userRespLow);
                        // System.out.println("Debugging:");
                        // for (int i = 0; i < result.length; i++) {
                        // if (result[i] != null) {
                        // System.out.println(result[i].getFoodPlaceName());
                        // }
                        // }
                        userRespLow = askQuestions();

                }

                System.out.println("Byeee!");
                printEmoji(sadEmoji());
        }

        public static String askQuestions() {
                Scanner in = new Scanner(System.in);// Creates scanner object.
                String userRespLow = "";

                switch (state) {
                        case 0:
                                System.out.println(
                                                "Welcome to the Restaurant Recommender! I am the Foodbot (pronounced Fooooood) and I'm here to help with what you're craving! Are you craving fast food, sit down, dessert, or nothing?");
                                break;
                        case 1:
                                System.out.println(
                                                "Is your price range less than 15 dollars? Reply with yes or no.");
                                break;
                        case 2:
                                System.out.println("Are you craving something spicy?");
                                break;
                        case 3:
                                System.out.println("Are you vegetarian?");
                                break;
                        case 4:
                                System.out.println("Are you ok with a restaurant with a rating less than 3 stars?");
                                break;
                        case 5:
                                System.out.println(
                                                "There are no restaurants that match your cravings. Please try again by entering anything. Exit out of the conversation by entering nothing.");
                                break;
                        case 6:
                                System.out.println("Write the restaurant name you would like to know more about.");
                                break;
                        case 7:

                                System.out.println(
                                                "Thank you. Type anything to continue for another food craving. Type 'nothing' to exit.");

                                break;
                        default:
                                break;
                }

                userRespLow = in.nextLine().toLowerCase();
                return userRespLow;
        }

        public static Restaurant[] processResponse(Restaurant[] restaurants, String userRespLow) {
                Restaurant[] result = restaurants;

                switch (state) {
                        case 0:
                                if (userRespLow.contains("fast food")) {
                                        for (int i = 0; i < fastfood.length; i++) {
                                                result[i] = fastfood[i];
                                        }

                                        state = 1;
                                } else if (userRespLow.contains("sit down")) {
                                        for (int i = 0; i < sitdown.length; i++) {
                                                result[i] = sitdown[i];
                                        }
                                        state = 1;
                                } else if (userRespLow.contains("dessert")) {
                                        for (int i = 0; i < dessert.length; i++) {
                                                result[i] = dessert[i];
                                        }
                                        state = 1;
                                } else {
                                        result = restaurants;
                                        System.out.println(getRandomResponse());
                                }

                                break;
                        case 1:
                                if (userRespLow.contains("yes")) {
                                        for (int i = 0; i < restaurants.length; i++) {
                                                if (restaurants[i].getPrice() >= 15) {
                                                        result[i] = null;
                                                }

                                        }
                                        state = 2;
                                } else if (userRespLow.contains("no")) {
                                        state = 2;
                                } else {
                                        System.out.println(getRandomResponse());
                                }
                                break;
                        case 2:
                                if (userRespLow.contains("yes")) {
                                        for (int i = 0; i < restaurants.length; i++) {
                                                if (restaurants[i] != null && restaurants[i].getSpicy() == false) {
                                                        result[i] = null;
                                                }
                                                state = 3;
                                        }
                                } else if (userRespLow.contains("no")) {

                                        state = 3;
                                } else {
                                        System.out.println(getRandomResponse());
                                }
                                break;
                        case 3:
                                if (userRespLow.contains("yes")) {
                                        for (int i = 0; i < restaurants.length; i++) {
                                                if (restaurants[i] != null
                                                                && restaurants[i].gethasvegetarian() == false) {
                                                        result[i] = null;
                                                }
                                        }
                                        state = 4;
                                } else if (userRespLow.contains("no")) {
                                        state = 4;
                                } else {
                                        System.out.println(getRandomResponse());
                                }
                                break;
                        case 4:
                                if (userRespLow.contains("no")) {
                                        for (int i = 0; i < restaurants.length; i++) {
                                                if (restaurants[i] != null && restaurants[i].getRating() < 3) {
                                                        result[i] = null;
                                                }
                                        }
                                        state = 5;
                                } else if (userRespLow.contains("yes")) {
                                        state = 5;
                                } else {
                                        System.out.println(getRandomResponse());
                                }
                                int count = 0;
                                for (int i = 0; i < result.length; i++) {
                                        if (result[i] == null) {
                                                count++;
                                        }
                                }
                                if (count != (result.length)) {
                                        System.out.print(
                                                        "Based on your answers, I, foodbot, recommend that you can go to the following Restaurant(s): ");

                                        int cnt = 0;
                                        for (int i = 0; i < result.length; i++) {
                                                if (result[i] != null) {
                                                        cnt++;
                                                }
                                        }
                                        for (int i = 0; i < result.length; i++) {
                                                if (result[i] != null) {
                                                        System.out.print(result[i].getFoodPlaceName());
                                                        cnt--;
                                                        if (cnt != 0) {
                                                                System.out.print(", ");
                                                        }
                                                }
                                        }
                                        System.out.println();
                                        state = 6;
                                }
                                break;
                        case 5:
                                state = 0;
                                break;
                        case 6:

                                for (int i = 0; i < restaurants.length; i++) {
                                        if (result[i] != null && userRespLow
                                                        .contains(result[i].getFoodPlaceName().toLowerCase())) {
                                                printEmoji(smilyEmoji());
                                                System.out.println("Here are some popular menu items: "
                                                                + result[i].getmenu() + ". It is "
                                                                + result[i].getMiles()
                                                                + " miles away from Amador Valley High School."
                                                                + " Use this link for more information: "
                                                                + result[i].getWebsite());
                                                state = 7;
                                                break;
                                        }

                                }
                                if (state == 6)
                                        System.out.println(getRandomResponse());

                                break;
                        case 7:
                                state = 0;
                                break;
                        default:
                                System.out.println(
                                                "Welcome to the Restaurant Recommender! I am the Foodbot(pronounced Fooooood) and I'm here to help with what you're craving! Are you craving fast food, sit down, dessert, or nothing?");
                                break;
                }
                return result;
        }

        public static Restaurant checkWord(Restaurant[] restaurants, String restaurantName) {
                for (Restaurant x : restaurants) {
                        if (x.getFoodPlaceName().toLowerCase().contains(restaurantName)) {
                                return x;
                        }
                }
                return null;
        }

        // One method you might need is getRandomResponse()
        public static String getRandomResponse() {
                int y = ((int) (Math.random() * 1000.0) % 3);
                if (y == 1) {
                        return "I'm not sure what you mean. Please try again.";
                } else if (y == 2) {
                        return "Stop wasting my time. Type something I can understand.";
                } else {
                        return "Give a direct answer to the question and be more clear.";

                }
        }

        public static boolean checkExit(String response) {
                for (String x : goodBye) {
                        if (response.toLowerCase().contains(x.toLowerCase())) {
                                return true;
                        }
                }
                return false;
        }
        // It'll generate a random response when the chatbot doesn't understand what to
        // say

        // Here is an example of a method you might use.
        public static String getResponse(String statement) {
                String response = "";
                if (statement.indexOf("no") >= 0) {
                        response = "Why so negative?";
                } else if (statement.indexOf("mother") >= 0
                                || statement.indexOf("father") >= 0
                                || statement.indexOf("sister") >= 0
                                || statement.indexOf("brother") >= 0) {
                        response = "Tell me more about your family.";
                } else {
                        // respoonse = getRandomResponse() <--- you will need to create this methodd.
                }
                return response;
        }

        public static void printEmoji(String[] lines) {
                for (String line : lines) {
                        System.out.println(line);
                }
        }

        public static String[] smilyEmoji() {
                String[] lines = {
                        "                        ⣀⣀⣤⣤⣤⣤⣤⣤⣤⣄⣀⡀",
                        "                 ⣀⣠⣴⣶⣿⡿⠿⠟⢛⣛⣛⣛⣛⣛⣛⣛⠻⠿⢿⣷⣶⣦⣀⡀",
                        "             ⢀⣤⣶⣿⡿⠟⣋⣭⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣭⣙⠛⢿⣷⣦⣄",
                        "          ⣀⣴⣿⠟⢋⣡⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣌⡙⠻⣷⣦⡀",
                        "        ⣠⣾⡿⠟⣡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⠻⢿⣧⡀",
                        "      ⣠⣾⡿⠋⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⠙⢿⣦⡀",
                        "    ⢀⣼⣿⠟⣡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⢻⣿⣄",
                        "   ⢀⣾⣿⠋⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠙⣿⣦",
                        "  ⢀⣾⣿⠃⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠘⣿⣧",
                        "  ⣾⣿⠇⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠁⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠸⣿⣇",
                        " ⢸⣿⣏⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⣠⣤⣀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠀⢀⣤⣄⡀⠈⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⢹⣿⡄",
                        "⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⡴⠿⡿⢿⣧⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⢠⡿⠿⣿⣧⡀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣷",
                        "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⢀⣠⣶⣄⡈⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⣠⣴⣦⡄⠁⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                        "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⢀⣿⣿⣿⣿⣷⡀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⣤⣿⣿⣿⣿⡄⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                        "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣤⣿⣿⣿⣿⣿⣿⣵⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣼⣾⣿⣿⣿⣿⣿⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                        "⢸⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                        "⠘⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿",
                        "⠀⢹⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⣠⣄⡉⠻⢿⣿⣿⣿⣿⣿⡇",
                        "  ⠘⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠀⣤⣿⣿⣿⣦⡀⠙⢿⣿⣿⡟",
                        "   ⠹⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⣄⠙⢿⣿⣿⣿⣿⣶⡀⠹⣿⠁",
                        "    ⠹⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠈⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠃⠀⣠⣾⣿⣷⣦⡈⢻⣿⣿⣿⣿⠀⠃",
                        "     ⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁⠀⠀⡀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⠟",
                        "      ⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣀⡀⠈⠉⠛⠿⠿⠿⠿⠿⠿⠿⠛⠋⠁⠀⣀⣠⣴⣿⣿⣷⣄⠉⠻⠿⣿⣿⣿⠿⠉",
                        "        ⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣴⣖⣶⣦⣤⣤⣤⣤⣤⣄⣐⣒⣶⣭⣽⣿⣿⣿⣿⣿⣿⣿⣦⣤⣀⣉",
                        "          ⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉",
                        "            ⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠁ ",
                        "               ⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠋⠁",
                        "                   ⠈⠙⠛⠻⠿⢿⠿⠿⣿⣿⣿⡿⠿⠿⠿⠟⠛⠋⠉"
                };
                return lines;   
 
        }

        public static String[] sadEmoji() {
                String[] lines = {
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡤⠄⠒⠚⠉⠉⠉⠉⠉⠉⠉⠉⠉⠒⠲⠤⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠂⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⣀⠴⠋⠀⠀⠀⠀⠀⣀⡤⠔⠒⢛⣷⠀⠀⠀⠀⢰⡟⠒⠲⠤⢄⡀⠀⠀⠀⠀⠈⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⢠⠞⠁⠀⠀⠀⠀⠀⣾⡃⣀⣤⣴⠾⠛⠉⠀⠀⠀⠀⠈⠙⠛⢶⣤⣄⠀⣹⡆⠀⠀⠀⠀⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⢀⡴⠁⠀⠀⠀⠀⠀⠀⠀⠘⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠁⠀⠀⠀⠀⠀⠀⠈⠳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⢀⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⢀⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⠀⠀⠀⠀⠀⡞⠀⠀⢰⢠⠀⠀⢀⠀⠀⠀",
                        "⠀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠖⠋⠉⠉⠉⠙⠲⢤⡀⠀⣠⠴⠚⠉⠉⠉⠉⠓⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡄⠀⠀⠀⠀⢸⣧⣀⣠⣿⡇⠀⠀⢸⡀⠀⠀",
                        "⢸⠁⠀⠀⠀⠀⠀⠀⠀⢀⡤⠚⠁⠀⢀⣾⣿⣿⣷⡄⠀⠈⠻⣾⠁⢀⣴⣿⣿⣿⣦⠀⠀⠀⠙⠢⣀⠠⠀⠀⠀⠀⠀⠀⠀⢷⠀⠀⠀⠀⣿⣀⠀⣸⡏⠉⠓⣲⣿⠃⠀⢰",
                        "⡌⠀⠀⠀⠀⠀⠀⠀⠀⢿⠁⠀⠀⠀⠸⣿⣿⣿⣿⡿⠄⠀⢀⣧⠀⠘⣿⣿⣿⣿⣿⠄⠀⠀⠀⠀⢹⢧⠀⠀⠀⠀⠀⠀⠀⣾⠀⠀⢱⢀⡇⠉⢩⣿⠛⠓⢴⡿⠙⠲⢤⡞",
                        "⡆⠀⠀⠀⠀⠀⠀⠀⠘⡌⢇⠀⠀⠀⠀⠙⠻⠿⠛⠀⠀⡠⠋⠈⠣⡀⠙⠻⠿⠟⠁⠀⠀⠀⠀⢀⢏⡎⠀⠀⠀⠀⠀⠀⠀⣿⣅⣀⡀⣿⢁⠀⠈⠁⠀⠀⠿⠟⠲⢤⡾⠁",
                        "⡇⠀⠀⠀⠀⠀⠀⠀⠀⠘⢌⠳⣄⠀⠀⠀⠀⠀⣀⠴⣫⠂⠀⠀⠀⠈⠳⢤⡀⠀⠀⠀⠀⢀⡴⢋⠞⠀⠀⠀⠀⠀⠀⠀⠀⠸⡏⠉⠀⠘⡼⣆⠀⠀⠀⠀⠀⠀⠀⡜⠀⠀",
                        "⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠒⠒⠚⠩⠒⠉⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠒⠒⠚⠭⠖⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⣦⡀⠀⠀⠀⡀⠀⠀⠀⠀⢀⡼⠀⠀⠀",
                        "⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠈⠻⣦⣀⠀⠇⠀⠀⠀⣠⠟⠀⠀⠀⠀",
                        "⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠇⠀⠀⢾⣿⣁⡀⠀⣴⠞⠁⠀⠀⠀⠀⠀",
                        "⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠀⠀⠀⠀⠈⠉⠉⠛⠋⠀⠀⠀⠀⠀⠀⠀",
                        "⠈⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⠤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⢤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠘⣿⣆⠀⠀⠀⠾⠾⠖⠚⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠓⠒⠒⢾⠇⠀⠀⣴⣾⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠘⣿⡗⠀⠂⠀⠀⠀⠠⠀⠀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠐⣶⢉⢸⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠙⢷⡦⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠛⠛⠛⠻⢿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⠛⠉⠁⠀⠀⠀⠀⠀⠈⢀⡼⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠈⠙⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠙⢦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⢦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠿⢶⣶⣤⣤⣤⣀⣀⣀⣀⣠⣤⣤⣴⣶⠾⠟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
                };
                return lines;

        }

}