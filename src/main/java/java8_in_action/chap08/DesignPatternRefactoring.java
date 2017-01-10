package java8_in_action.chap08;

public class DesignPatternRefactoring {
  public static void main(String[] args) {
    Validator numericValidator = new Validator(new IsNumeric());
    boolean b1 = numericValidator.validate("aaaa");

    Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
    boolean b2 = lowerCaseValidator.validate("bbbb");


//    Validator numericValidator =
//            new Validator((String s) -> s.matches("[a-z]+"));
//    boolean b1 = numericValidator.validate("aaaa");
//
//    Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
//    boolean b2 = lowerCaseValidator.validate("bbbb");
  }
}

interface ValidationStrategy {
  boolean execute(String s);
}

class IsAllLowerCase implements ValidationStrategy {
  @Override
  public boolean execute(String s) {
    return s.matches("[a-z]+");
  }
}

class IsNumeric implements ValidationStrategy {
  @Override
  public boolean execute(String s) {
    return s.matches("\\d+");
  }
}

class Validator {
  private final ValidationStrategy strategy;

  public Validator(ValidationStrategy v) {
    this.strategy = v;
  }

  public boolean validate(String s) {
    return strategy.execute(s);
  }
}