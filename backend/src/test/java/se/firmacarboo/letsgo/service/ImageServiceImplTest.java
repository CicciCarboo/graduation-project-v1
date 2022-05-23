package se.firmacarboo.letsgo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
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
    void testRegisterNewImage_imageUrlOccupied_shouldProduceMessageOfFailure() {

        // given
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
        String message = "There is already an image with imageUrl: " + image1.getImageUrl();

        // a stub?
        // when the mocked repository's insert method is called, then return image
        when(this.imageRepository.insert((Image) any())).thenReturn(image);

        // a stub?
        // when the mocked repository's findImageByImageUrl(imageUrl) method is called,
        // then return the Optional value of image1
        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(ofResult);

        // a dummy?
        Image image2 = new Image();
        image2.setId("42");
        image2.setImageAltText("Image Alt Text");
        image2.setImageUrl("https://example.org/example");
        image2.setName("Name");
        image2.setUsageType(UsageType.BRUSHTEETH);

        // then

        // This is a mock?
        assertEquals(message, this.imageServiceImpl.registerNewImage(image2));

        // Mocks. They are only concerned with what method is called, and when.
//        these methods check that the mocked repository is called by the given methods.
        verify(this.imageRepository, times(0)).insert((Image) any());
        verify(this.imageRepository, times(1)).findImageByImageUrl(any());

//        Finally, this method asserts that imageServiceImpl truly only interacted
//        with the mocked imageRepository = no connection to database.
        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());
    }

    @Test
    void testRegisterNewImage_ValidImageUrl_shouldPass() {

        // given
        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/example");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);

        //stubs
        when(this.imageRepository.insert((Image) any())).thenReturn(image);
        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(Optional.empty());

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
        verify(this.imageRepository).findImageByImageUrl(any());

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
        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(ofResult);

        Image image2 = new Image();
        image2.setId("42");
        image2.setImageAltText("Image Alt Text");
        image2.setImageUrl("https://example.org/example");
        image2.setName("Name");
        image2.setUsageType(UsageType.BRUSHTEETH);
        assertEquals("There is already an image with imageUrl: https://example.org/example",
                this.imageServiceImpl.registerNewImage(image2));
        verify(this.imageRepository).findImageByImageUrl(any());

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
        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(Optional.empty());

        Image image1 = new Image();
        image1.setId("42");
        image1.setImageAltText("Image Alt Text");
        image1.setImageUrl("https://example.org/example");
        image1.setName("Name");
        image1.setUsageType(UsageType.BRUSHTEETH);
        assertEquals("Image has been successfully inserted.", this.imageServiceImpl.registerNewImage(image1));
        verify(this.imageRepository).insert((Image) any());
        verify(this.imageRepository).findImageByImageUrl(any());

        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());
    }

    @Test
    void shouldUpdateImageSuccessfully() {
        // TDD
        // updateOne() returns a document holding:
        // matchedCount: 1 (documents matching the query), modifiedCount: 1(documents modified), acknowledged: false (write concern)

        // given
        Image image = new Image();
        image.setId("42");
        image.setImageAltText("Image Alt Text");
        image.setImageUrl("https://example.org/NEWurl");
        image.setName("Name");
        image.setUsageType(UsageType.BRUSHTEETH);

        Image imageInDB = new Image();
        imageInDB.setId("42");
        imageInDB.setImageAltText("Image Alt Text");
        imageInDB.setImageUrl("https://example.org/example");
        imageInDB.setName("Name");
        imageInDB.setUsageType(UsageType.BRUSHTEETH);

        // This update shall succeed
        when(this.imageRepository.findById(any())).thenReturn(Optional.of(imageInDB));
        when(this.imageRepository.existsByImageUrl(any())).thenReturn(false);

        // when
        assertEquals("Image successfully updated.", imageServiceImpl.updateImage(image));

        // then
        verify(this.imageRepository).findById(any());
        verify(this.imageRepository).existsByImageUrl(any());

        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());

        /*Todo on successful update
         * get id from provided image CHECK!
         * findImageById CHECK!
         * compare fields to find which one was updated
         * if imageUrl was updated, compare new imageUrl with existing ones in database CHECK!
         * if Optional of findImageByUrl is empty, proceed CHECK!
         * call imageRepository.save(image) CHECK!
         * */

        /*Todo on denied update due to URL
         * get id from provided image
         * findImageById
         * compare fields to find which one was updated
         * if imageUrl was updated, compare new imageUrl with existing ones in database
         * if Optional of findImageByUrl is occupied, abort
         * verify that imageRepository.save() was never called.
         * */

        /*Todo on denied update due to invalid id
         * get id from provided image
         * findImageById
         * if null = findImageById, return error message
         * assert that error message was thrown
         * verify that imageRepository.save() was never called.
         * */
    }

        /*
            TODO Delete method tests
             * Test for happy path CHECK!
             * Test for failure
             */

    @Test
    public void testDeleteImage_shouldPass() {
        // Testing Happy path.

        // given
        Image imageInDB = new Image();
        imageInDB.setId("42");
        imageInDB.setImageAltText("Image Alt Text");
        imageInDB.setImageUrl("https://example.org/example");
        imageInDB.setName("Name");
        imageInDB.setUsageType(UsageType.BRUSHTEETH);

        // This update shall succeed
        when(this.imageRepository.findById(any())).thenReturn(Optional.of(imageInDB));

        // when
        imageServiceImpl.deleteImageById(any());

        // then
        verify(this.imageRepository).findById(any());
        verify(this.imageRepository).deleteById(any());
    }
}













