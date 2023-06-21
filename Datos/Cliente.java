package Datos;


import Interface.Menu;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import Logica.Validacion;

public class Cliente extends Usuario implements Menu {
    private int idCliente;
    private double dineroDisponible;
    private JFrame ventana;
    private JButton botonVerPerfil;
    private JButton botonJugar;
    private JButton botonVerHistorial;
    private JButton botonAgregarDinero;
    private JButton botonRetirarDinero;
    private JPanel panel;
   
	public Cliente() {
			
	}
    public Cliente(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion,
                   String correoElectronico, int idCliente, double dineroDisponible) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico);
        this.idCliente = idCliente;
        this.dineroDisponible = dineroDisponible;
    }

    public Cliente(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion,
                   String correoElectronico, int idCliente) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico);
        this.idCliente = idCliente;
        this.dineroDisponible = 0;
    }




    public int getIdCliente(String nombre_usuario) {
        Conexion con = new Conexion();
        int idCliente= 0; // Valor por defecto en caso de que no se encuentre el usuario

        try (Connection conexion = con.conectar();
             PreparedStatement stmt = conexion.prepareStatement("SELECT id_usuario FROM usuario WHERE nombre_usuario = ?");
        ) {
            stmt.setString(1, nombre_usuario);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("id_usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al obtener el ID del usuario: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return idCliente;
    }


    public int getNroCliente(int id){

        int nroCliente = 0;

        Conexion con = new Conexion();
        try (Connection conexion = con.conectar();
             PreparedStatement stmt = conexion.prepareStatement("SELECT id_cliente FROM cliente WHERE id_usuario = ?");
        ) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nroCliente = rs.getInt("id_cliente");
                return nroCliente;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al obtener el ID del usuario: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return nroCliente;
        }


        return nroCliente;


    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }



    // Metodos del cliente

    public String getHistorialPartidas(String idCliente) {

        Conexion con = new Conexion();
        StringBuilder historial = new StringBuilder();



        int id_cliente;

        id_cliente = this.getIdCliente(idCliente);

        int id;
        id = this.getNroCliente(id_cliente);
        try  {
            Connection conexion = con.conectar();

            String sql = "SELECT p.fecha, j.nombre, p.monto_apostado, p.resultado " +
                    "FROM partida AS p " +
                    "INNER JOIN juego AS j ON p.juego = j.id_juego " +
                    "WHERE p.cliente = ? " +
                    "ORDER BY p.fecha DESC";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String fecha = rs.getString("fecha");
                String nombreJuego = rs.getString("nombre");
                double montoApostado = rs.getDouble("monto_apostado");
                int resultado = rs.getInt("resultado");

                String rdo;
                if(resultado == 0){
                    rdo = "Perdió";
                }
                else {
                    rdo = "Ganó";
                }
                historial.append("Fecha: ").append(fecha).append("\n");
                historial.append("Juego: ").append(nombreJuego).append("\n");
                historial.append("Monto Apostado: ").append(montoApostado).append("\n");
                historial.append("Resultado: ").append(rdo).append("\n");
                historial.append("------------------------\n");
            }
        } catch (Exception e) {
            return "Hubo un error al obtener el historial de partidas." + e.getMessage();
        }

        return historial.toString();
    }



    public double getDineroDisponible(int id) {
        Conexion con = new Conexion();
        double dineroDisponible = 0;

        try {
            Connection conexion = con.conectar();

            String sql = "SELECT SUM(tcc.monto)  AS total_monto " +
                    "  FROM transaccion_caja_cliente tcc\n" +
                    "            INNER JOIN cliente c ON tcc.cliente = c.id_cliente\n" +
                    "            WHERE c.id_usuario = ?"
          ;;

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dineroDisponible = rs.getDouble("total_monto");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
        }

        return dineroDisponible;
    }


    public void cargarSaldoOnline(double monto, String nombre_usuario){

        int id_cliente;
        id_cliente = this.getIdCliente(nombre_usuario);
        int id;
        id = this.getNroCliente(id_cliente);

        Conexion con = new Conexion();

        int caja = (int) (Math.random() * 3) + 1;
        int tipoTransaccion = 1;
        Date fecha = new Date();


        try {
            Connection conexion = con.conectar();

            String sql = "INSERT INTO transaccion_caja_cliente(monto, tipo_transaccion, cliente, fecha, caja) VALUES (?, ?, ?, ?,?)";

            PreparedStatement stmt = conexion.prepareStatement(sql);

            stmt.setDouble(1, monto);
            stmt.setInt(2, tipoTransaccion);
            stmt.setInt(3, id);
            stmt.setDate(4, new java.sql.Date(fecha.getTime()));
            stmt.setInt(5, caja);

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar la transaccion: " + e.getMessage());
        }
    }

    public boolean retirarDinero(double monto, String nombre_usuario) {
        int id_cliente;
        id_cliente = this.getIdCliente(nombre_usuario);
        int id;
        id = this.getNroCliente(id_cliente);

        Conexion con = new Conexion();

        Caja caja1 = new Caja();

        int tipoTransaccion = 2;
        Date fecha = new Date();



        double saldo, saldo1, saldo2;
        saldo = caja1.getSaldoActual(1);
        saldo1 = caja1.getSaldoActual(2);
        saldo2 = caja1.getSaldoActual(3);

        int caja = -1; // Variable para almacenar el número de caja con suficiente saldo

        if (saldo >= monto) {
            caja = 1;
        } else if (saldo1 >= monto) {
            caja = 2;
        } else if (saldo2 >= monto) {
            caja = 3;
        }

        if (caja != -1) {
            try {
                monto = monto * (-1);
                Connection conexion = con.conectar();

                String sql = "INSERT INTO transaccion_caja_cliente(monto, tipo_transaccion, cliente, fecha, caja) VALUES (?, ?, ?, ?,?)";

                PreparedStatement stmt = conexion.prepareStatement(sql);

                stmt.setDouble(1, monto);
                stmt.setInt(2, tipoTransaccion);
                stmt.setInt(3, id);
                stmt.setDate(4, new java.sql.Date(fecha.getTime()));
                stmt.setInt(5, caja);

                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println("Hubo un error al registrar la transaccion: " + e.getMessage());
                return false;
            }

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos no tenemos dinero suficiente en una sola caja para el retiro", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }



    public String verCuenta(int id) {

        String infoCuenta = "";
        Conexion con = new Conexion();

        try {
            Connection conexion = con.conectar();
            String sql = "SELECT u.nombre, u.apellido, u.direccion, u.email, u.fec_nacimiento " +
                    "FROM usuario AS u INNER JOIN cliente AS c " +
                    "ON u.id_usuario = c.id_usuario " +
                    "WHERE u.id_usuario = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dineroDisponible = String.valueOf(this.getDineroDisponible(id));
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String fecNacimiento = rs.getString("fec_nacimiento");

                infoCuenta += "Nombre: " + nombre + "\n";
                infoCuenta += "Apellido: " + apellido + "\n";
                infoCuenta += "Dinero disponible: "+dineroDisponible+"\n";
                infoCuenta += "Dirección: " + direccion + "\n";
                infoCuenta += "Email: " + email + "\n";
                infoCuenta += "Fecha de Nacimiento: " + fecNacimiento + "\n";
            } else {
                infoCuenta = "El cliente no fue encontrado.";
            }
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
            infoCuenta = "Hubo un error al consultar la cuenta del cliente.";
        }

        return infoCuenta;
    }


    public boolean jugar(int idJuego, String nombre_usuario, double apuesta) {

        int id_cliente;
        int cliente;
        cliente = this.getIdCliente(nombre_usuario);
        id_cliente = this.getNroCliente(cliente);

        String rutaImagenGano = "img/thumbs-up.png";
        ImageIcon iconoGano = new ImageIcon(rutaImagenGano);

        String rutaImagenPerdio = "img/thumbs-down.png";
        ImageIcon iconoPerdio = new ImageIcon(rutaImagenPerdio);


        Juego juego = new Juego();
        Caja caja1 = new Caja();


        Conexion con = new Conexion();

        Date fecha = new Date();
        boolean resultado;

        resultado = juego.generarResultado();
        EmpleadoCaja emp = new EmpleadoCaja();

        double monto;
        monto = apuesta * 4;
        int caja;
        caja = 1;
        double saldo, saldo2, saldo3;

        saldo = caja1.getSaldoActual(1);
        saldo2 =caja1.getSaldoActual(2);
        saldo3 = caja1.getSaldoActual(3);


        if(juego.getMaquina().getDaniada(idJuego)){
            JOptionPane.showMessageDialog(null, "Lo sentimos, la maquina esta dañada",
                    "Maquina dañada", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(juego.getMaquina().getHabilitada(idJuego)){
            JOptionPane.showMessageDialog(null, "Lo sentimos, la maquina no esta habilitada",
                    "Maquina no habilitada", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            else if (saldo < monto && saldo2<monto && saldo3 <monto) {

            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay suficiente dinero en las cajas " +
                            "para afrontar la apuesta",
                    "Saldo insuficiente", JOptionPane.ERROR_MESSAGE);
                return false;

        } else {
            if (resultado) {
                this.cargarSaldoOnline(monto, nombre_usuario);
                if(saldo>saldo2 && saldo>saldo3){
                    caja = 1;
                }
                else if(saldo2>saldo && saldo2>saldo3){
                    caja = 2;
                }
                else{
                    caja = 3;
                }
                emp.agregarDinero(monto * (-1), "juancito23", caja);

                JOptionPane.showMessageDialog(null, "Felicitaciones! has ganado " + monto, "Ganaste",
                        JOptionPane.INFORMATION_MESSAGE, iconoGano);
            } else {
                this.cargarSaldoOnline(apuesta * (-1), nombre_usuario);
                emp.agregarDinero(apuesta, "juancito23", caja);

                JOptionPane.showMessageDialog(null, "LO SENTIMOS! has perdido ", "Perdiste",
                        JOptionPane.INFORMATION_MESSAGE, iconoPerdio);
            }

            // Registrar la partida en la base de datos
            try {
                Connection conexion = con.conectar();
                String sql = "INSERT INTO partida (juego, cliente, monto_apostado, fecha, resultado) " +
                        "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement stmt = conexion.prepareStatement(sql);

                stmt.setInt(1, idJuego);
                stmt.setInt(2, id_cliente);
                stmt.setDouble(3, apuesta);
                stmt.setDate(4, new java.sql.Date(fecha.getTime()));
                stmt.setBoolean(5, resultado);

                stmt.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al registrar la partida: " + e.getMessage());
            }

            return true;
        }
    }


    public boolean login(String nombreUsuario, String contrasena) {
        Conexion con = new Conexion();

        try (Connection conexion = con.conectar()) {
            String sql = "SELECT COUNT(*) FROM usuario u " +
                    "INNER JOIN cliente c ON u.id_usuario = c.id_usuario " +
                    "WHERE u.nombre_usuario = ? AND u.contrasena = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                if (count > 0) {
                    return true; // Existe un usuario con el ID y contraseña proporcionados en la tabla cliente
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al validar el login: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }


    public void mostrarMenu(String id) {
        int idCliente = getIdCliente(id);
        ventana = new JFrame("Mi Aplicación");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);

        botonVerPerfil = new JButton("Ver perfil");
        botonJugar = new JButton("Jugar");
        botonVerHistorial = new JButton("Ver historial partidas");
        botonAgregarDinero = new JButton("Agregar dinero");
        botonRetirarDinero = new JButton("Retirar dinero");


        JTextArea textAreaVerPerfil;
        textAreaVerPerfil = new JTextArea();
        textAreaVerPerfil.setEditable(false);

        panel = new JPanel();
        panel.add(botonVerPerfil);
        panel.add(botonJugar);
        panel.add(botonVerHistorial);
        panel.add(botonAgregarDinero);
        panel.add(botonRetirarDinero);


        ventana.add(panel);
        ventana.setVisible(true);

        Validacion validar = new Validacion();

        botonVerPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String informacionCuenta = verCuenta(idCliente);

                textAreaVerPerfil.setText(informacionCuenta);
                panel.add(textAreaVerPerfil);
            }
        });

        botonJugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double apuesta = 0;

                Connection conexion = Conexion.conectar();
                String consultaJuegos = "SELECT nombre FROM juego";
                ArrayList<String> nombresJuegos = new ArrayList<>();

                try {
                    PreparedStatement statementJuegos = conexion.prepareStatement(consultaJuegos);
                    ResultSet resultSetJuegos = statementJuegos.executeQuery();

                    while (resultSetJuegos.next()) {
                        String nombreJuego = resultSetJuegos.getString("nombre");
                        nombresJuegos.add(nombreJuego);
                    }

                    String[] opcionesJuegos = nombresJuegos.toArray(new String[0]);
                    JComboBox<String> comboBoxJuegos = new JComboBox<>(opcionesJuegos);

                    int opcionSeleccionada = JOptionPane.showOptionDialog(null, comboBoxJuegos,
                            "Seleccione juego", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, null, null);

                    if (opcionSeleccionada == JOptionPane.OK_OPTION) {
                        int idJuegoSeleccionado = opcionSeleccionada + 1;
                        apuesta = Double.parseDouble(JOptionPane.showInputDialog(null,
                                "Cuánto desea apostar?"));

                        if (validar.validarJugar(apuesta, idCliente)) {
                            jugar(idJuegoSeleccionado, id, apuesta);
                        }
                    }

                    resultSetJuegos.close();
                    statementJuegos.close();
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        botonVerHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, getHistorialPartidas(id),
                        "Historial de partidas",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonAgregarDinero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Cuánto dinero desea cargar?", "Carga de dinero", JOptionPane.QUESTION_MESSAGE));

                if (validar.validarCargaDinero(idCliente, monto)) {
                    cargarSaldoOnline(monto, id);
                }
            }
        });

        botonRetirarDinero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double retiro = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Cuánto dinero desea retirar?", "Retiro de dinero", JOptionPane.QUESTION_MESSAGE));

                if (validar.validarRetiroDinero(idCliente, retiro)) {
                    retirarDinero(retiro, id);
                }
            }
        });
    }

}
