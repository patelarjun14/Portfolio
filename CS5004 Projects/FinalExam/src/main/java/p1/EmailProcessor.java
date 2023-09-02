package p1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
Class EmailProcessor provides functionality related to processing of a specific email account. For a given email
account, it allows searching and filtering emails by a sender, by a recipients, by subject and by date sent.
 */
public class EmailProcessor {

  private EmailAccount emailAccount;
  private static final Integer RECIPIENTS_CUTOFF = 5;

  public EmailProcessor(EmailAccount emailAccount) {
    this.emailAccount = emailAccount;
  }

  public EmailAccount getEmailAccount() {
    return emailAccount;
  }


  /**
   * This is a method that uses functional programming. It takes the email account and gets a list
   * of sent emails. After getting the list of emails sent, the method iterates through and filters
   * based on the subject of the email and matches it with the provided subject that is entered through
   * the parameter. It then adds another filter to see if the date sent matches the date provided within
   * the parameter. After it has filtered this, it collects the subjects and collects them into a list and
   * returns the list
   * @param date Entered in as LocalDate. This is the date of the email
   * @param subject Entered in as a String. This is the subject of the email
   * @return Returns a list of Strings that are the subjects of the emails that were filtered
   * based on the parameters
   */
  public List<String> mysteryMethod(LocalDate date, String subject){

    return this.emailAccount.getSentEmails().stream().filter(x -> x.getSubject().equals(subject))
                            .filter(z -> z.getDateSent().equals(date))
                            .map(w -> w.getSubject()).collect(Collectors.toList());
  }


  /**
   * This is a method that uses functional programming and contains a helper function called getAllEmails.
   * This method takes all emails from an email account and filters all the emails by the parameters listed
   * below. Once the method has filtered all the emails, it then put all emails into a lit. This method
   * will return that list of emails.
   * @param sender Entered as a String. The person who sent the email
   * @param recipient Entered as a String. The person who received the email.
   * @param date Enter as a LocalDate. The date the email was sent or received.
   * @return A list of emails that match the given parameters
   */
  public List<Email> filterSentEmailsBySenderRecipientAndDate(String sender, String recipient, LocalDate date){
    return this.emailAccount.getAllEmails().stream().filter(x->x.getSender().equals(sender))
                                                    .filter(z->z.getRecipients().contains(recipient))
                                                    .filter(w->w.getDateSent().equals(date))
                                                    .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EmailProcessor)) return false;
    EmailProcessor that = (EmailProcessor) o;
    return Objects.equals(getEmailAccount(), that.getEmailAccount());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmailAccount());
  }

  @Override
  public String toString() {
    return "EmailProcessor{" +
        "emailAccount=" + emailAccount +
        '}';
  }
}
