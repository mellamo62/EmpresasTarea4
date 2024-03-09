package org.iesbelen.empresasmalaga.Commands;

import org.iesbelen.empresasmalaga.domain.Empresa;
import org.iesbelen.empresasmalaga.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//Esta clase se ejecuta al iniciar springboot y lo que hace es introducir datos a la base de datos automaticamente.
@Component
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public void run(String... args) throws Exception {
        empresaRepository.saveAll(List.of(
                new Empresa(1, "Dulann", "Simplificamos el Cumplimiento de la Normativa EHSQ ¡Tan fácil como reservar un vuelo! dulann es un Sistema de Administración de Conformidad Digital\n" +
                        "¡Optimizamos tu EHS, Calidad, Mantenimiento y Aprendizaje Digital! Nuestra Promesa de Marca\n" +
                        "\"Mayor eficiencia y cumplimiento de la normativa para nuestros clientes. ¡Garantizado!\"\n" +
                        "\n", "C. Fiscal Luis Portero García 7, Bloque 7 First Floor, Office 12 A, 29010 Málaga", "https://www.dulann.com/assets/images/es/campaigns/dulann-logo.png", 36.71734817590269, -4.460459089403146, parseDate("2013-05-06")),
                new Empresa(2, "NTT Data", "Construyamos una sociedad mejor. Desde servicios de consultoría estratégica hasta tecnologías de vanguardia, desarrollamos experiencias que transforman organizaciones, revolucionan industrias y dan forma a una sociedad mejor para todos. Transformamos compañías, anticipándonos al futuro. Somos una multinacional especializada en servicios de consultoría tecnológica con sede en Tokio, que continúa sumando territorios en los que seguir innovando a través de las tecnologías emergentes, con el objetivo de desarrollar proyectos innovadores que contribuyan a mejorar la vida de las personas.\n" +
                        "\n" +
                        "Para ello, ofrecemos a nuestros clientes servicios de consultoría estratégica, aplicaciones, infraestructuras y servicios de BPO, ayudándoles a superar los retos de hoy y de mañana.", "C. Prta del Mar, 18, Distrito Centro, 29005 Málaga", "https://mc-8afc6902-e56c-432c-8c3f-3991-cdn-endpoint.azureedge.net/-/media/project/emea/shared/global-logo/globallogo_nttdata_white_resized.png?hash=", 36.71871057443188, -4.422939396148495, parseDate("1988-05-23")),
                new Empresa(3, "Sogeti", "El nombre de Sogeti tiene su origen en Francia y es el nombre del origen de todo el Grupo Cap Gemini, fundado por Serge Kampf en 1967. El nombre es un acrónimo de 'Société pour la gestion et le traitement de l'information', lo que traducido sería 'Sociedad para la gestión y tratamiento de la información'\n" +
                        "\n" +
                        "\n" +
                        "Tras varios años de cambios, en 2002, el Grupo Capgemini otorgó a Sogeti su nombre original.  Hoy en día, tras más de 50 años de historia y experiencia en el sector IT, somos más de 25.000 Sogetians repartidos entre las más de 100 localizaciones en todo el mundo (Europa, India y Estados Unidos).", "C. Severo Ochoa, 71, Campanillas, 29590 Málaga", "https://www.sogeti.es/Static/img/sogeti-logo.svg", 36.74032823632366, -4.552906489402348, parseDate("1967-06-06")),
                new Empresa(4, "Anovo", "Facilitamos un futuro sostenible para el sector tecnológico. En ANOVO somos líderes en economía circular en tecnología. Esto se debe a que hemos conseguido alargar la vida útil de más de 50 millones de dispositivos electrónicos en nuestras más de dos décadas de experiencia en el sector. Aportamos valor en cada una de las 9Rs de la economía circular, que son: rediseñar, reducir, reutilizar, reparar, revalorizar, renovar, remanufacturar, reconvertir y reciclar.\n" +
                        "\n" +
                        "Ofrecemos servicios 360º para las empresas del sector de la tecnología y otros sectores. Entre ellos se encuentran la logística inversa inteligente, la ingeniería inversa en infraestructura y redes y el servicio técnico oficial como líder en acreditaciones homologadas por los principales fabricantes de tecnología.\n" +
                        "\n" +
                        "ANOVO apuesta por la economía sostenible gracias a la realización de prácticas enfocadas a la circularidad electrónica basadas en la responsabilidad ambiental. El camino de ANOVO se dirige hacia la transformación tecnológica, la eficiencia energética, la tecnología eco-amigable, la huella ecológica y, en definitiva, a la sostenibilidad electrónica.\n" +
                        "\n" +
                        "Estamos muy orgullosos de contar con el respaldo que recibimos por parte de nuestros clientes, quienes permanecen a nuestro lado por más de 14 años de media, mostrando así su confianza en nuestro trabajo. Su testimonio es la clara representación del compromiso, la dedicación y la relación construida a lo largo de los años. ", "C. Charles Darwin, sn, Campanillas, 29590 CAMPANILLAS, Málaga", "https://www.anovo.es/wp-content/uploads/2023/08/logotipo_ANOVO-blanco-140x55.png", 36.74141684582545, -4.554127376760474, parseDate("1998-06-06")),
                new Empresa(5, "CGI", "Through our global insights and local experts, we help build the strategies and deliver the end-to-end services that help clients achieve meaningful and sustainable outcomes. We are committed to making our story about you and your successful journey, serving as an insightful and resourceful partner.Founded in 1976, CGI is among the largest IT and business consulting services firms in the world. We are insights-driven and outcomes-based to help accelerate returns on your investments.Insights you can act on\n" +
                        "Insights are incredibly powerful. They look to space to help sustain life on Earth. They transfer trillions of dollars through secure payments. They power homes with clean energy. They benefit the wellbeing of millions of citizens. They are all around us, but it’s unlocking them that matters.", "Blvr. Louis Pasteur, 47, Campanillas, 29010 Málaga", "https://www.pta.es/wp-content/uploads/2020/04/logo-CGI.jpg", 36.718714572715825, -4.497079074057506, parseDate("1976-06-06"))

        ));

        System.out.println("ALL DATA SAVED");
    }

    //Esta funcion sirve para convertir un string en fecha.
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
