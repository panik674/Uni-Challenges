import java.io.BufferedReader;
import java.net.*;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.net.URL;
class emailID {
    public static void main(String[] args) throws MalformedURLException, java.io.IOException {
        Scanner IDInput = new Scanner(System.in);
        System.out.println("Enter an email ID and the owner's name will be returned ");
        String ID = IDInput.nextLine();
        URL url = new URL("https://www.ecs.soton.ac.uk/people/" + ID);
        System.out.println(url);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        String search = "property=\"name\"";
        while ((line = in.readLine()) != null) {
            try {
                if (line.contains(search)) {
                    String nameSub = (line.substring(line.indexOf(search) + search.length() + 1, line.length()));
                    System.out.println(nameSub.substring(0, nameSub.indexOf("<")));
                }

            }
            catch (Exception e) {
            }
        }
    }
}







