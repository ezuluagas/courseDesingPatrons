package creacionales.abstractFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AbstractFactoryDemo {

    public static void main(String args[]) throws ParserConfigurationException, IOException, SAXException {
        String xml="<document><body><stock>APPL</stock></body></document>";

        ByteArrayInputStream bais=new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractFactory=DocumentBuilderFactory.newInstance(); // abstract factory no sabemos cual es la implementacion de esta solo sabemos q obtenemos nuestros documentos

        DocumentBuilder factory=abstractFactory.newDocumentBuilder();  //factory

        Document doc=factory.parse(bais);  // clase concreta

        System.out.println("Root element: "+doc.getDocumentElement().getNodeName());

        System.out.println(abstractFactory.getClass());
        System.out.println(factory.getClass());


        /**
         *
         */

        CreditCardFactory abstractFactoryCard =CreditCardFactory.getCreditCardFactory(775);

        CreditCard card=abstractFactoryCard.getCreditCard(CardType.PLATIUM);

        System.out.println(card.getClass());

        abstractFactoryCard=CreditCardFactory.getCreditCardFactory(600);

        CreditCard card2=abstractFactoryCard.getCreditCard(CardType.GOLD);

        System.out.println(card2.getClass());
    }
}
