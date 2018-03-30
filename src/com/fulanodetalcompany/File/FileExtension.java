/*
 * Copyright 2018 Roberto Alonso De la Garza Mendoza.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fulanodetalcompany.File;

import java.io.File;

/**
 * Helper to manipulate extension of file
 * @author Roberto Alonso De la Garza Mendoza
 */
public class FileExtension {
    private File file;

    public FileExtension(String file) throws NotAFileException {
        this.file = new File(file);
        if (this.file.isDirectory()) {
            throw new NotAFileException("The element is not a file");
        }
    }

    public FileExtension(File file) throws NotAFileException {
        if (file.isFile()) {
            this.file = file;
        }else{
            throw new NotAFileException("The element is not a file");
        }
    }
    /**
     * Get the extension of a file
     * @param file
     * @return the extension of a file
     * @throws NotAFileException The element is not a file
     * @throws FileWithoutExtension The file has not extension
     */
    public String getExtension(File file) throws 
            NotAFileException,
            FileWithoutExtension
    {
        String extension = "";
        if(file.isDirectory()){
            throw new NotAFileException("The element is not a file");
        }
        String[] file_split = file.getName().split(".");
        if (file_split.length > 0) {
            extension = file_split[file_split.length -1];
        }else{
            throw new FileWithoutExtension("The file has not extension");
        }
        return extension;
    }
    
    public File setExtension(String file,String extension) throws NotAFileException
    {
        return setExtension(new File(file),extension);
    }
    
    public File setExtension(File file,String extension) throws NotAFileException
    {
        if (extension.isEmpty() || extension == null) {
            throw new NullPointerException("The extension can not be null or empty");
        }
        if (this.file.isDirectory()) {
            throw new NotAFileException("The element is not a file");
        }
        
        return file;
    }
    
}
