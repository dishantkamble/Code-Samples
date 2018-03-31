package tlvprocessor;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import tlvprocessor.config.TlvTypes;
import tlvprocessor.parser.Parser;

/**
 * @author Dishant Kamble
 *
 */
public class TlvProcessor {

  /**
   * @param args
   * @throws IOException if the input file is not found.
   */
  public static void main(String[] args) throws IOException {
    Scanner inputFileScanner = null;
    try {
      inputFileScanner = new Scanner(new FileReader("inputTest.txt"));
      String currentLine = null;
      Parser tlvParser;

      while (inputFileScanner.hasNext()) {
        currentLine = inputFileScanner.next();
        tlvParser = splitfunction(currentLine);

        if (Objects.isNull(tlvParser)) {
          System.out.println("Type Not Valid");
        } else {
          tlvParser.operate();
          System.out.println(tlvParser.getType() + "-" + tlvParser.getValue());
        }
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {
      if (inputFileScanner != null)
        inputFileScanner.close();
    }
  }

  private static boolean ifValidType(String string) {
    if (string != null) {
      for (TlvTypes validType : TlvTypes.values()) {
        if (validType.name().equals(string))
          return true;
      }
    }
    return false;
  }

  /**
   * Takes a line from the input file and splits it to return an instance of {@link Parser}.
   * 
   * @param string {@link String} input string to split type, length and value.
   * @return an instance of {@link Parser} with type, length and value.
   */
  public static Parser splitfunction(String string) {
    String[] afterSplitStringArray = null;
    if (string != null) {
      afterSplitStringArray = string.split("-");
      String type = afterSplitStringArray[0];
      String length = afterSplitStringArray[1];
      if (ifValidType(type)) {
        String value = afterSplitStringArray[2];
        Parser tlvParser = new Parser(type, length, value);
        return tlvParser;
      }
    }
    return null;
  }
}
