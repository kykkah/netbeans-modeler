/** Copyright [2014] Gaurav Gupta
   *
   *Licensed under the Apache License, Version 2.0 (the "License");
   *you may not use this file except in compliance with the License.
   *You may obtain a copy of the License at
   *
   *    http://www.apache.org/licenses/LICENSE-2.0
   *
   *Unless required by applicable law or agreed to in writing, software
   *distributed under the License is distributed on an "AS IS" BASIS,
   *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   *See the License for the specific language governing permissions and
   *limitations under the License.
   */
package org.netbeans.modeler.widget.properties.customattr;



public class GenericProperty {

    private String key = null;
    private Object value = null;
 
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

 
    
    public GenericProperty(String key, Object value)
    {
        this.key = key;
        this.value = value;
    }
    
 
    public GenericProperty()
    {
        this.key = "";
    }

    
    @Override
    public String toString()
    {
        return getKey();
    }
    
}
