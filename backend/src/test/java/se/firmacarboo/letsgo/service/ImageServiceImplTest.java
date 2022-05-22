package se.firmacarboo.letsgo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.firmacarboo.letsgo.entity.Image;
import se.firmacarboo.letsgo.entity.UsageType;
import se.firmacarboo.letsgo.repository.ImageRepository;

@ContextConfiguration(classes = {ImageServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ImageServiceImplTest {
    @MockBean
    private ImageRepository imageRepository;

    @Autowired
    private ImageServiceImpl imageServiceImpl;

    @Test
    void testRegisterNewImage() {

        // given


        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/example");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);
        String expectedImageRegistrationSuccessMessage = "Image has been successfully inserted.";


        Image image1 = new Image();
        image1.setId("42");
        image1.setImageAltText("Image Alt Text");
        image1.setImageUrl("https://example.org/example");
        image1.setName("Name");
        image1.setUsageType(UsageType.BRUSHTEETH);
        Optional<Image> ofResult = Optional.of(image1);

        // a stub?
        // when the mocked repository's insert method is called, then return image
        when(this.imageRepository.insert((Image) any())).thenReturn(image);

        // a stub?
        // when the mocked repository's findImageByImageUrl(imageUrl) method is called, then return the Optional value of image1
        when(this.imageRepository.findImageByImageUrl((String) any())).thenReturn(ofResult);

        // a dummy?
        Image image2 = new Image();
        image2.setId("42");
        image2.setImageAltText("Image Alt Text");
        image2.setImageUrl("https://example.org/example");
        image2.setName("Name");
        image2.setUsageType(UsageType.BRUSHTEETH);

        // then

        // This is a mock?
        // this will return that there already exists an image (image1) with that imageUrl.
        assertEquals(expectedImageRegistrationSuccessMessage, this.imageServiceImpl.registerNewImage(image2));

        // Mocks. They are only concerned with what method is called, and when.
//        these methods check that the mocked repository is called by the given methods.
        verify(this.imageRepository).insert((Image) any());
        verify(this.imageRepository).findImageByImageUrl((String) any());

//        this method asserts that there was no image registered, the database is still empty. (will return false, because it's calling the true database right now???)
        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());
    }

    @Test
    void testRegisterNewImage2() {

        // given
        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/example");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);

        //stubs
        when(this.imageRepository.insert((Image) any())).thenReturn(image);
        when(this.imageRepository.findImageByImageUrl((String) any())).thenReturn(Optional.empty());

        // dummy?
        Image image1 = new Image();
        image1.setId("42");
        image1.setImageAltText("Image Alt Text");
        image1.setImageUrl("https://example.org/example");
        image1.setName("Name");
        image1.setUsageType(UsageType.BRUSHTEETH);

        assertEquals("Image has been successfully inserted.", this.imageServiceImpl.registerNewImage(image1));

        //mocks
        verify(this.imageRepository).insert((Image) any());
        verify(this.imageRepository).findImageByImageUrl((String) any());

//        this should fail. The insert should be successfull, since the optional returned in findImageByUrl was empty.
//        OR, are we asserting that the actual ImageRepository never was called, and thus the database stays empty?
        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());
    }

    @Test
    void testRegisterNewImage3() {
        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/example");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);

        Image image1 = new Image();
        image1.setId("42");
        image1.setImageAltText("Image Alt Text");
        image1.setImageUrl("https://example.org/example");
        image1.setName("Name");
        image1.setUsageType(UsageType.BRUSHTEETH);
        Optional<Image> ofResult = Optional.of(image1);
        when(this.imageRepository.insert((Image) any())).thenReturn(image);
        when(this.imageRepository.findImageByImageUrl((String) any())).thenReturn(ofResult);

        Image image2 = new Image();
        image2.setId("42");
        image2.setImageAltText("Image Alt Text");
        image2.setImageUrl("https://example.org/example");
        image2.setName("Name");
        image2.setUsageType(UsageType.BRUSHTEETH);
        assertEquals("There is already an image with imageUrl: https://example.org/example",
                this.imageServiceImpl.registerNewImage(image2));
        verify(this.imageRepository).findImageByImageUrl((String) any());

//        This method should succeed, because no image could be registered.???
        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());
    }

    @Test
    void testRegisterNewImage4() {
        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/example");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);
        when(this.imageRepository.insert((Image) any())).thenReturn(image);
        when(this.imageRepository.findImageByImageUrl((String) any())).thenReturn(Optional.empty());

        Image image1 = new Image();
        image1.setId("42");
        image1.setImageAltText("Image Alt Text");
        image1.setImageUrl("https://example.org/example");
        image1.setName("Name");
        image1.setUsageType(UsageType.BRUSHTEETH);
        assertEquals("Image has been successfully inserted.", this.imageServiceImpl.registerNewImage(image1));
        verify(this.imageRepository).insert((Image) any());
        verify(this.imageRepository).findImageByImageUrl((String) any());

//        This should fail? The database should be populated?
        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());
    }

    @Test
    void testCalculation(){
        // A little warm up

        // given
        int firstValue = 10;
        int secondValue = 20;

        // when
        int result = Math.max(firstValue, secondValue);

        // then
        assertEquals(secondValue, result);
    }

    @Test
    void shouldUpdateImageSuccessfully(){
        /*Log:
        20220522 16:27h ImageServiceImpl.updateImage() empty. Test should fail.
        Result:
        Expected :Image has been successfully updated.
        Actual   :null

        20220522 16:27h ImageServiceImpl.updateImage() empty.
        Changed return type of method to boolean. Test should fail.
        Result
        Expected :true
        Actual   :false

        */

        // updateOne() returns a document (=object) holding: matchedCount: 1 (documents matching the query), modifiedCount: 1(documents modified), acknoledged: false (write concern)
        // given
        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/NEWurl");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);

        Image imageInDB = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/example");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);

        // This update shall succeed
//    not in use    when(this.imageRepository.save((Image) any())).thenReturn(image); // returns image now, in reality returns object with write results
        when(this.imageRepository.findById((String) any())).thenReturn(Optional.of(imageInDB));
        when(this.imageRepository.existsByImageUrl((String) any())).thenReturn(false);

        // when
        assertEquals("Image successfully updated.", imageServiceImpl.updateImage(image));
//        imageServiceImpl.updateImage(image);

        // then
        verify(this.imageRepository).findById((String) any());
        verify(this.imageRepository).existsByImageUrl((String) any());
//     not in use   verify(this.imageRepository).save((Image) any());


//        This should fail? The database should be populated?
        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());

        /**Todo on successful update
         * get Image to update
         * get id from image
         * findImageById
         * compare fields to find which one was updated
         * if imageUrl was updated, compare new imageUrl with existing ones in database
         * if Optional of findImageByUrl is empty, proceed
         * call imageRepository.save(image)
         * */

        /**Todo on denied update due to URL
         * get Image to update
         * get id from image
         * findImageById
         * compare fields to find which one was updated
         * if imageUrl was updated, compare new imageUrl with existing ones in database
         * if Optional of findImageByUrl is occupied, abort
         * verify that imageRepository.save() was never called.
         * */

        /**Todo on denied update due to id
         * get Image to update
         * get id from image
         * if null = findImageById, return error message
         * assert that error message was thrown
         * verify that imageRepository.save() was never called.
         * */


    }
}

