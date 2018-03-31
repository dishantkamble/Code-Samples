package tlvprocessor.config;

/**
 * This enum acts as a configuration to list all valid Types acceptable for the TLV Processor.
 * 
 * By adding more enum entries and overriding the {{@link #performOperation(String)} method for each
 * entry, more operations can be added.
 * 
 * @author Dishant Kamble
 *
 */
public enum TlvTypes {

  UPPRCS {
    @Override
    public String performOperation(String string) {
      return string.toUpperCase();
    }
  },
  REPLCE {
    @Override
    public String performOperation(String string) {
      return "THIS STRING";
    }
  };

  public abstract String performOperation(String string);
}
