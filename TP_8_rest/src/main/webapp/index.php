<html>
    <head>
        <title>Agenda</title>
    </head>

    <body>
        <h1 align="center"><p>AGENDA</p></h1>
        <p><b>Ingrese un contacto:</b></p>
        
        <form action="http://localhost:8080/Prog3Practico08Rest2/rest/agenda" method="post">
            <table>
                <! –– FILA 1 -->
                <tr>
                    <td><p style="text-align: right;">Nombre: </p></td> 
                    <td><input type="text" id="nombre" name="nombre"></td>
                </tr>

                <! –– FILA 2 -->
                <tr>
                    <td><p style="text-align: right;">Apellido: </p></td> 
                    <td><input type="text" id="apellido" name="apellido"></td>
                </tr>
                
                <! –– FILA 3 -->
                <tr>
                    <td><p style="text-align: right;">Telefono: </p></td> 
                    <td><input type="text" id="telefono" name="telefono"></td>
                </tr>

                <! –– FILA 4 -->
                <tr>
                    <td><p style="text-align: right;">Email: </p></td> 
                    <td><input type="text" id="email" name="email"></td>
                </tr>

                <! –– FILA 5 -->
                <tr>
                    <td><p style="text-align: right;">Domicilio: </p></td> 
                    <td><input type="text" id="domicilio" name="domiciio"></td>
                </tr>


                <! –– FILA 12 -->
                <tr><td><p> <br> </p></td></tr>

                <! –– FILA 13 -->
                <tr>
                    <td colspan="10" align="center">
                        <input type="submit" value="Ingresar" style="font-size: 18px;">
                    </td>
                </tr>

            </table>
        </form>


        
        <h1 align="left"><p>LISTADO</p></h1>

        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Telefono</td>
                <td>Email</td>
                <td>Direccion</td>
                
                
            </tr>

            <?php
           
            $conexion = mysqli_connect('localhost', 'root', 'root', 'restdb');
            
            if ($conexion->connect_error) {
                die("Connection failed: " . $conexion->connect_error);
            }
            
            

            $sql="SELECT * FROM agenda";
            //$result=mysqli_query($conexion, $sql);
            
            $result = $conexion->query($sql);

            if ($result->num_rows > 0) {
              // output data of each row
                while($row = $result->fetch_assoc()) {
                  
                  
                ?>
            <tr>
                <td><?php echo $row['id'] ?></td>
                <td><?php echo $row['nombre'] ?></td>
                <td><?php echo $row['apellido'] ?></td>
                <td><?php echo $row['telefono'] ?></td>
                <td><?php echo $row['email'] ?></td>
                <td><?php echo $row['domicilio'] ?></td>
                <td><a href="borrar.php?id=<?php echo $row['id'];?>">Borrar</a></td>
                <td><a href="modificar.php?id=<?php echo $row['id']?>&nombre=<?php echo $row['nombre']?>&apellido=<?php echo $row['apellido']?>&telefono=<?php echo $row['telefono']?>&email=<?php echo $row['email']?>&domicilio=<?php echo $row['domicilio']?>">Modificar</a></td>
                       
                       
                
            </tr>
            
            <?php
                }
            
            }
                $conexion->close();
            ?>
        </table>
        

    </body>
</html>

