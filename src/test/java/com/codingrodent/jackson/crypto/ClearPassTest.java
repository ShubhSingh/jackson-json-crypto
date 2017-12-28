/*
* MIT License
*
*         Copyright (c) 2017
*
*         Permission is hereby granted, free of charge, to any person obtaining a copy
*         of this software and associated documentation files (the "Software"), to deal
*         in the Software without restriction, including without limitation the rights
*         to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*         copies of the Software, and to permit persons to whom the Software is
*         furnished to do so, subject to the following conditions:
*
*         The above copyright notice and this permission notice shall be included in all
*         copies or substantial portions of the Software.
*
*         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*         IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*         FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*         AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*         LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*         OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*         SOFTWARE.
*/
package com.codingrodent.jackson.crypto;

import com.codingrodent.jackson.crypto.pojos.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ClearPassTest {

    @Test
    public void encrypt2() throws Exception {

        InsecurePojo insecurePojo = new InsecurePojo("Something not very secure ...");
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new CryptoModule());
        String json = objectMapper.writeValueAsString(insecurePojo);
        InsecurePojo result = objectMapper.readValue(json, InsecurePojo.class);
        assertEquals(insecurePojo.getCritical(), result.getCritical());
    }
}