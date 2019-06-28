import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import webapp.dto.Manufacturer;
import webapp.mapper.ManufacturerMapper;
import webapp.service.ManufacturerService;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class ManufacturerServiceTest {

    private ManufacturerService service;
    private Manufacturer manufacturer;
    private ManufacturerMapper mapper = Mappers.getMapper(ManufacturerMapper.class);

    @Before
    public void setUp() throws Exception {
        manufacturer = new Manufacturer()
                .setName("Asus");

        service.createOne(manufacturer);
    }

    @Test
    public void createManufacturer() {
        Manufacturer manufacturer = new Manufacturer()
                .setName("Acer");

        service.createOne(manufacturer);
        Manufacturer manufacturerByName = (Manufacturer) service.findOneById(1L);
        assertEquals(manufacturer, mapper.mapManufacturerEntityToManufacturer(manufacturerByName));
    }

    @Test
    public void getManufacturerById() {
        Manufacturer manufacturerById = (Manufacturer) service.findOneById(1L);

        assertEquals(manufacturer, mapper.mapManufacturerEntityToManufacturer(manufacturerById));
    }


    @Test
    public void deleteManufacturerById() {
        service.deleteOneById(1L);

        assertNull(service.findOneById(1L));
    }

    @Test
    public void getAllManufacturers() {
        assertEquals(4, service.findAll().size());
    }

}
