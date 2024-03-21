package com.utility;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;
import org.junit.Before;
import org.junit.Test;

public class MyUtilitiesTest {

    private MyUtilities myUtilities;
    
    @Before
    public void setUp() {
        myUtilities = new MyUtilities();
    }

    @Test
    public void testUploadFile_ValidExtensionAndSize() throws Exception {
        FileItem item = mock(FileItem.class);
        when(item.isFormField()).thenReturn(false);
        when(item.getName()).thenReturn("testfile.txt");
        when(item.getSize()).thenReturn(1024L); // 1 KB

        ArrayList<String> allowedExtensions = new ArrayList<>();
        allowedExtensions.add(".txt");

        String destinationPath = "/path/to/destination/";

        String result = myUtilities.UploadFile(item, destinationPath, allowedExtensions);

        assertEquals("testfile.txt", result);
        verify(item).write(new File("/path/to/destination/testfile.txt"));
    }

    @Test
    public void testUploadFile_InvalidExtension() throws Exception {
        FileItem item = mock(FileItem.class);
        when(item.isFormField()).thenReturn(false);
        when(item.getName()).thenReturn("testfile.exe");
        when(item.getSize()).thenReturn(1024L); // 1 KB

        ArrayList<String> allowedExtensions = new ArrayList<>();
        allowedExtensions.add(".txt");

        String destinationPath = "/path/to/destination/";

        String result = myUtilities.UploadFile(item, destinationPath, allowedExtensions);

        assertEquals("", result); // Expecting empty string for invalid extension
        verify(item, never()).write(any(File.class)); // Ensure write method is not called
    }

    @Test
    public void testUploadFile_ExceedsSizeLimit() throws Exception {
        FileItem item = mock(FileItem.class);
        when(item.isFormField()).thenReturn(false);
        when(item.getName()).thenReturn("testfile.txt");
        when(item.getSize()).thenReturn(11 * 1024 * 1024L); // 11 MB

        ArrayList<String> allowedExtensions = new ArrayList<>();
        allowedExtensions.add(".txt");

        String destinationPath = "/path/to/destination/";

        String result = myUtilities.UploadFile(item, destinationPath, allowedExtensions);

        assertEquals("", result); // Expecting empty string for size exceeding limit
        verify(item, never()).write(any(File.class)); // Ensure write method is not called
    }
}
