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
package com.fulanodetalcompany.common;

import com.fulanodetalcompany.File.FileExtension;
import com.fulanodetalcompany.File.FileWithoutExtension;
import com.fulanodetalcompany.File.NotAFileException;
import java.io.File;

/**
 * Helper for files manipulation
 * @author Roberto Alonso De la Garza Mendoza
 */
public class FileManager {
    public final File file;
    public final FileExtension extensionManager;
    /**
     * Constructor
     */
    public FileManager(String file) throws NotAFileException {
        this.file = new File(file);
        this.extensionManager = new FileExtension(file);
    }
    /**
     * Constructor
     * @param file
     * @throws NotAFileException 
     */
    public FileManager(File file) throws NotAFileException {
        this.file = file;
        this.extensionManager = new FileExtension(file);
    }
    
    /**
     * Units
     */
    public enum Unit{
        Byte,
        Megabits,
        Gigabits,
        Terabits
    }
    /**
     * 
     */
    public static long Megabyte = 1 * 1000000;
    /**
     * 
     */
    public static long Gigabyte = Megabyte * 1000;
    /**
     * 
     */
    public static long Terabyte = Gigabyte * 1000;
    
    /**
     * Get the total size of any element<br>
     * <br>
     * Get the total size, if the element
     * is a folder, the result is the total
     * of all the sub-files containt in the
     * root element
     * @param element a file
     * @return total in bytes
     */
    public long getSize(File element){
        if (element.isFile()) {
            return element.length();
        }else{
            long total = 0;
            for (File child : element.listFiles()) {
                total = total + getSize(child);
            }
            return total;
        }
    }
    /**
     * Get the total size of any element<br>
     * <br>
     * Get the total size, if the element
     * is a folder, the result is the total
     * of all the sub-files containt in the
     * root element
     * @param element a file
     * @param unit the result unit
     * @return  total in the given unit
     */
    public long getSize(File element,Unit unit){
        long size = getSize(element);
        switch(unit){
            case Megabits:
                size = size / Megabyte;
                break;
            case Gigabits:
                size = size / Gigabyte;
                break;
            case Terabits:
                size = size / Terabyte;
                break;
                default:
                    break;
        }
        return size;
    }
    /**
     * 
     * @param extension
     * @return
     * @throws NotAFileException 
     */
    public File setExtension(String extension) throws NotAFileException
    {
        return this.extensionManager.setExtension(this.file, extension);
    }
    /**
     * 
     * @return
     * @throws NotAFileException 
     */
    public String getExtension() throws NotAFileException, FileWithoutExtension
    {
        return this.extensionManager.getExtension(this.file);
    }
}
