package tlvprocessor.parser;

import tlvprocessor.config.TlvTypes;

/**
 * @author Dishant Kamble
 *
 */
public class Parser {

  private String type;
  private String length;
  private String value;

  /**
   * Overloaded constructor to use type, length and value of the input parameter to return an
   * instance of {@link Parser}.
   * 
   * @param type {@link String}
   * @param length {@link String}
   * @param value {@link String}
   */
  public Parser(String type, String length, String value) {
    this.type = type;
    this.length = length;
    this.value = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLength() {
    return this.length;
  }

  public void setLength(String len) {
    this.length = len;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Method to identify the type and perform respective operation using the
   * {@link TlvTypes#performOperation(String)} method.
   */
  public void operate() {
    for (TlvTypes validType : TlvTypes.values()) {
      if (validType.name().equals(this.getType())) {
        this.setValue(validType.performOperation(this.getValue()));
        break;
      }
    }
  }
}
