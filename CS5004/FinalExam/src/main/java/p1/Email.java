package p1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/*
Class email contains information about an email - email address of a sender, email addresses of all recipients,
CC-ed recipients, as well as information whether or not someone was BCC-ed. Additionally, class contains
information about a subject of an email, and the date it was sent. Note: email address is stored as a String,
in a format: name@domain (e.g., t.bonaci@northeastern.edu)
 */
public class Email {

  private String sender;
  private List<String> recipients;
  private List<String> CCedRecipients;
  private Boolean BCCedRecipentsIncluded;
  private String subject;
  private LocalDate dateSent;

  public Email(String sender, List<String> recipients, List<String> CCedRecipients,
               Boolean BCCedRecipentsIncluded, String subject, LocalDate dateSent) {
    this.sender = sender;
    this.recipients = recipients;
    this.CCedRecipients = CCedRecipients;
    this.BCCedRecipentsIncluded = BCCedRecipentsIncluded;
    this.subject = subject;
    this.dateSent = dateSent;
  }

  public String getSender() {
    return sender;
  }

  public List<String> getRecipients() {
    return recipients;
  }

  public List<String> getCCedRecipients() {
    return CCedRecipients;
  }

  public Boolean getBCCedRecipentsIncluded() {
    return BCCedRecipentsIncluded;
  }

  public String getSubject() {
    return subject;
  }

  public LocalDate getDateSent() {
    return dateSent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Email)) return false;
    Email email = (Email) o;
    return Objects.equals(getSender(), email.getSender()) &&
        Objects.equals(getRecipients(), email.getRecipients()) &&
        Objects.equals(getCCedRecipients(), email.getCCedRecipients()) &&
        Objects.equals(getBCCedRecipentsIncluded(), email.getBCCedRecipentsIncluded()) &&
        Objects.equals(getSubject(), email.getSubject()) &&
        Objects.equals(getDateSent(), email.getDateSent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSender(), getRecipients(), getCCedRecipients(),
        getBCCedRecipentsIncluded(), getSubject(), getDateSent());
  }

  @Override
  public String toString() {
    return "Email{" +
        "sender='" + sender + '\'' +
        ", recipients=" + recipients +
        ", CCedRecipients=" + CCedRecipients +
        ", BCCedRecipentsIncluded=" + BCCedRecipentsIncluded +
        ", subject='" + subject + '\'' +
        ", dateSent=" + dateSent +
        '}';
  }
}
