package adapter;

import java.io.File;
import java.time.LocalDate;

import business.Country;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

//import com.danibuiza.jaxb.ultimate.business.Country;

/**
 * Simple example of usage of jaxb marshaling functionalities when managing complex classes, in this
 * case java.time.LocalDate
 * 
 * @author dgutierrez-diez
 */
public class JaxBExampleAdapter
{

    public static void main( String[] args )
    {
        try
        {

            /* init very simple data to marshal */
            Country country = new Country();
            country.setName( "Spain" );
            country.setCapital( "Madrid" );
            country.setContinent( "Europe" );


            country.setFoundation( LocalDate.of( 1469, 10, 19 ) );

            Country country2 = new Country();
            country2.setName( "Euskal Herria" );
            country2.setCapital( "Eibar" );
            country2.setContinent( "Europe" );


            country2.setFoundation( LocalDate.of( 1312, 05, 01 ) );

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Country.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( country2, new File( "country_adapter.xml" ) );

            jaxbMarshaller.marshal( country2, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
