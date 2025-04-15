# FURNACE (Dependency Inversion Principle)

The following program is built losely followed the guidelines of the Furnace Kata that can be found in Chapter 11 of _Robert C. Martin_ & _Micah Martin_'s [*Agile Principles, Patterns and Practices in C#*](https://www.amazon.es/Principles-Patterns-Practices-Robert-Martin/dp/0131857258).

Through it's use it exhibits the dependency inversion principle at work by it's widespread usage of the abstract interfaces ``Heater`` and ``Thermometer`` despite the necesity of accessing methods that are not accesible through their abstract forms. 

### FURNACE DIP
*<sub>edu.estatuas.furnace</sub>*<br>
&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;└ FurnaceApp.java <sub>(main)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├ Heater <sub>(interface)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;├ GasHeater <sub>(class)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;└ WoodStove <sub>(class)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├ Thermometer <sub>(interface)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;├ DigitalThermo <sub>(class)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║&nbsp;&nbsp;&nbsp;&nbsp;└ MercuryThermo <sub>(class)</sub><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;║<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└ Room <sub>(class)</sub><br>
