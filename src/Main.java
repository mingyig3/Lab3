import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  /**
   * Retrieve contents from a URL and return them as a string.
   *
   * @param url url to retrieve contents from
   * @return the contents from the url as a string, or an empty string on error
   */
  public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
      urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
      return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
  }

  /**
   * Count appearance of word.
   * @param args the argument.
   */
  public static void main(String[] args) {
    String research = urlToString("http://erdani.com/tdpl/hamlet.txt");
    research = research.toUpperCase();
    Pattern p = Pattern.compile("PRINCE");
    Matcher m = p.matcher(research);
    int count = 0;
    while (m.find()) {
      count += 1;
    }
    System.out.print(count);
  }
}
