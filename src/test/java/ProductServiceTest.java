
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import webapp.dto.Manufacturer;
import webapp.dto.Product;
import webapp.entity.ProductEntity;
import webapp.mapper.ManufacturerMapper;
import webapp.mapper.ProductMapper;
import webapp.repository.ProductRepository;
import webapp.service.ManufacturerService;
import webapp.service.ProductService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class ProductServiceTest {
    private ProductService productService;
    private ManufacturerService manufacturerService;
    private ProductRepository repository;
    private Product product;
    private ManufacturerMapper manufacturerMapper = Mappers.getMapper(ManufacturerMapper.class);
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Before
    public void setUp() {
        Manufacturer manufacturer = new Manufacturer()
                .setName("Asus");

        manufacturerService.createOne(manufacturer);

        product = new Product()
                .setName("KeyBoard")
                .setPrice(new BigDecimal("100.00"))
                .setManufacturer(manufacturerMapper.mapManufacturerEntityToManufacturer(manufacturerService.findOneById(1L)));

        productService.createOne(product);
    }

    @Test
    public void createProduct() {
        Product testProduct = new Product()
                .setName("Laptop")
                .setPrice(new BigDecimal("1000.00"))
                .setManufacturer(manufacturerMapper.mapManufacturerEntityToManufacturer(manufacturerService.findOneById(1L)));

        productService.createOne(testProduct);

        ProductEntity productEntity = repository.findById(5L).orElse(null);
        assertEquals(testProduct, productEntity);
    }

    @Test
    public void getProductById() {
        ProductEntity productEntity = productMapper.mapProductToProductEntity((Product) productService.findOneById(1L));
        assertEquals(product, productEntity);
    }

    @Test
    public void deleteProductId() {
        productService.deleteOneById(1L);
        assertNull(productService.findOneById(1L));
    }

    @Test
    public void getAllProducts() {
        assertEquals(2, productService.findAll().size());
    }
}
