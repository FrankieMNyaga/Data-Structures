public class Person {
  private String personID;
  private String phoneNum;
  private Person nextPerson;
  public Person(String personID, String phoneNum) {
    this.personID = personID;
    this.phoneNum = phoneNum;
  }
  public String getPersonID() {
    return personID;
  }
  public String getPhoneNum() {
    return phoneNum;
  }
  public void setPersonID(String setID) {
    personID = setID;
  }
  public void setPhoneNum(String setNum) {
    phoneNum = setNum;
  }
  public Person getNext() {
    return nextPerson;
  }
  public void setNextPerson(Person p) {
    this.nextPerson = p;
  }
  public String getPerson() {
    return this.getPersonID()+this.getPhoneNum();
  }
}