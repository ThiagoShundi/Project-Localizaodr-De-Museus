package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * CollectionTypeServiceTest.
 */
@DisplayName("Class CollectionTypeService")
@SpringBootTest
public class CollectionTypeService {
  @MockBean
  MuseumFakeDatabase museumFakeDatabase;
  @Autowired
  CollectionTypeService collectionTypeService;

  @Test
  public void testCollectionTypeService() throws Exception {
    String typeList = "hist";

    Mockito.when(museumFakeDatabase.countByCollectionType(any()).thenReturn(typeList));
    CollectionTypeCount collectionTypeCount = collectionTypeService.countByCollectionTypes(typeList);

    assertEquals(collectionTypeCount.count(), collectionTypeService.countByCollectionTypes(typeList).count());

    Mockito.verify(museumFakeDatabase).countByCollectionType(typeList);
  }
}
