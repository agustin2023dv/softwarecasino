
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

class Main {

	public static void main(String[] args) {

		
		
		// Clientes

		Cliente cliente1 = new Cliente(1, "Juan", "Gomez", new Date(06 - 05 - 2023), "12341",
				"mail1@gmail.com", 1, 190.00);
		Cliente cliente2 = new Cliente(2, "Maria", "Lopez", new Date(06 - 05 - 2023), "12342",
				"mail2@gmail.com", 2, 1000.00);
		Cliente cliente3 = new Cliente(3, "Pedro", "Guzman", new Date(06 - 05 - 2023), "12343",
				"mail3@gmail.com", 3, 1000.00);
		Cliente cliente4 = new Cliente(4, "Marta", "Ferrero", new Date(06 - 05 - 2023), "12344",
				"mail4@gmail.com", 4, 1000.00);
		Cliente cliente5 = new Cliente(5, "Lucas", "Garcia", new Date(06 - 05 - 2023), "12345",
				"mail5@gmail.com", 5, 1000.00);

		// Administrador

		Administrador admin1 = new Administrador(6, "Roberto", "Lopez", new Date(06 - 05 - 2023), "12346",
				"mail6@gmail.com", 1);
		Administrador admin2 = new Administrador(7, "Graciela", "Mussa", new Date(06 - 05 - 2023), "12347",
				"mail7@gmail.com", 2);
		Administrador admin3 = new Administrador(8, "Mariela", "Vazquez", new Date(06 - 05 - 2023), "12348",
				"mail8@gmail.com", 3);

		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		administradores.add(admin1);
		administradores.add(admin2);
		administradores.add(admin3);
		// Empleado caja

		EmpleadoCaja empleadoCaja1 = new EmpleadoCaja(9, "Marcos", "Lopez", new Date(06 - 05 - 2023), "12349",
				"mail9@gmail.com", 1, "Caja", 1);
		EmpleadoCaja empleadoCaja2 = new EmpleadoCaja(10, "Julian", "Rocca", new Date(06 - 05 - 2023),
				"123410", "mail10@gmail.com", 2, "Caja", 2);
		EmpleadoCaja empleadoCaja3 = new EmpleadoCaja(11, "Lucia", "Perez", new Date(06 - 05 - 2023),
				"123411", "mail11@gmail.com", 3, "Caja", 3);

		ArrayList<EmpleadoCaja> empleadosCaja = new ArrayList<EmpleadoCaja>();
		empleadosCaja.add(empleadoCaja1);
		empleadosCaja.add(empleadoCaja2);
		empleadosCaja.add(empleadoCaja3);
		// Empleado tecnico

		Tecnico tecnico1 = new Tecnico(12, "Jorge", "Hernandez", new Date(06 - 05 - 2023), "123412",
				"mail12@gmail.com", 4, "Tecnico", 1);
		Tecnico tecnico2 = new Tecnico(13, "Pedro", "Domingo", new Date(06 - 05 - 2023), "123413",
				"mail13@gmail.com", 5, "Tecnico", 2);
		Tecnico tecnico3 = new Tecnico(14, "Walter", "Pedroso", new Date(06 - 05 - 2023), "123414",
				"mail14@gmail.com", 6, "Tecnico", 3);

		ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
		tecnicos.add(tecnico1);
		tecnicos.add(tecnico2);
		tecnicos.add(tecnico3);

		// Empleado maquina

		EmpleadoMaquina empleadoMaquina1 = new EmpleadoMaquina(15, "nombre15", "apellido15", new Date(06 - 05 - 2023),
				"123415", "mail15@gmail.com", 7, "Maquina", 1);
		EmpleadoMaquina empleadoMaquina2 = new EmpleadoMaquina(16, "nombre16", "apellido16", new Date(06 - 05 - 2023),
				"123416", "mail16@gmail.com", 8, "Maquina", 2);
		EmpleadoMaquina empleadoMaquina3 = new EmpleadoMaquina(17, "nombre17", "apellido17", new Date(06 - 05 - 2023),
				"123417", "mail17@gmail.com", 9, "Maquina", 3);

		ArrayList<EmpleadoMaquina> empleadosMaquina = new ArrayList<EmpleadoMaquina>();

		empleadosMaquina.add(empleadoMaquina1);
		empleadosMaquina.add(empleadoMaquina2);
		empleadosMaquina.add(empleadoMaquina3);

		// Array de todos los usuarios

		ArrayList<Usuario> usuarioEjemplo = new ArrayList<Usuario>();

		usuarioEjemplo.add(cliente1);
		usuarioEjemplo.add(cliente2);
		usuarioEjemplo.add(cliente3);
		usuarioEjemplo.add(cliente4);
		usuarioEjemplo.add(cliente5);
		usuarioEjemplo.add(admin1);
		usuarioEjemplo.add(admin2);
		usuarioEjemplo.add(admin3);
		usuarioEjemplo.add(empleadoCaja1);
		usuarioEjemplo.add(empleadoCaja2);
		usuarioEjemplo.add(empleadoCaja3);
		usuarioEjemplo.add(tecnico1);
		usuarioEjemplo.add(tecnico2);
		usuarioEjemplo.add(tecnico3);
		usuarioEjemplo.add(empleadoMaquina1);
		usuarioEjemplo.add(empleadoMaquina2);
		usuarioEjemplo.add(empleadoMaquina3);
		
		// Array clientes

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);

		// Maquinas
		
		ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
		
		Maquina maquina1 = new Maquina(1, 100, false, true);
		Maquina maquina2 = new Maquina(2, 100, false, true);
		Maquina maquina3 = new Maquina(3, 100, false, true);
		
		maquinas.add(maquina1);
		maquinas.add(maquina2);
		maquinas.add(maquina3);		
		
		// Juegos

		ArrayList<Juego> juegos = new ArrayList<Juego>();

		Juego caraOCruz = new Juego(1, "Cara o cruz",
				"Cara o Cruz es un juego de azar en el que se lanza una moneda para predecir el resultado: cara o cruz.",
				1, 6, maquina1);
		Juego dados = new Juego(2, "Dados",
				"Dados es un juego de azar en el que se lanzan dados para predecir el resultado de la suma de los números obtenidos",
				1, 6, maquina2);
		Juego blackjack = new Juego(3, "Blackjack",
				"Blackjack es un juego de cartas en el que los jugadores intentan obtener una mano con un valor total cercano a 21 sin pasarse.",
				1, 6, maquina3);

		juegos.add(caraOCruz);
		juegos.add(dados);
		juegos.add(blackjack);
		
		// Cajas

		ArrayList<Caja> cajas = new ArrayList<Caja>();
		
		Caja caja1 = new Caja(1, 100.00, 50.0, null);
		empleadoCaja1.setCaja(caja1);
		Caja caja2 = new Caja(2, 1000.00, 500.0, null);
		empleadoCaja1.setCaja(caja2);
		Caja caja3 = new Caja(3, 10000.00, 5000.0, null);
		empleadoCaja1.setCaja(caja3);
		
		cajas.add(caja1);
		cajas.add(caja2);
		cajas.add(caja3);

		
		//-------------------------------------------------------------------------------------------------------------

		// Arreglo de juegos

		String[] opcionesJuegos = new String[juegos.size()];


		// Agregacion del nombre de los juegos al array opcionesJuegos

		for (int i = 0; i < juegos.size(); i++) {
			opcionesJuegos[i] = juegos.get(i).getNombre();
		}



		// INICIO

		// Pantalla de Bienvenida

		String rutaImagenInicio = "img/casinoInicio.jpg";
		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);
		JOptionPane.showMessageDialog(null, "Bienvenido al casino Jocker",
				"Casino Jocker", JOptionPane.PLAIN_MESSAGE, iconoInicio);


		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);

		String[] opciones = { "Cliente", "Empleado de caja","Administrador", "Empleado de Maquina",  "Tecnico" };

		int choice = JOptionPane.showOptionDialog(
						null,
						"Por favor seleccione su tipo de usuario. Gracias.",
						"Seleccion tipo de usuario",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						iconoPreLogin,
						opciones,
						opciones[0]);

		if (choice == JOptionPane.CLOSED_OPTION) {
			System.exit(0); // Cierra la aplicación si no se selecciona ninguna opción
		} else {


		// Botones de usuario

		String nombreIngresado = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Log in: Nombre ", JOptionPane.PLAIN_MESSAGE);
		String contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña:", "Log in: Contraseña ", JOptionPane.PLAIN_MESSAGE);


		// Iconos: Pulgar arriba , Pulgar abajo, Gracias por jugar

			String rutaImagenGano= "img/thumbs-up.png";
			ImageIcon iconoGano = new ImageIcon(rutaImagenGano);

			String rutaImagenPerdio= "img/thumbs-down.png";
			ImageIcon iconoPerdio = new ImageIcon(rutaImagenPerdio);


			String rutaGracias= "img/graciasPorJugar.png";
			ImageIcon iconoGracias = new ImageIcon(rutaGracias);

			// Usuario actual = null;

		boolean quiereJugar = true;

		switch (choice) {
			case 0: // Cliente

				Cliente actual = null;
				for (Cliente cliente : clientes) {
					if (cliente.getNombre().equalsIgnoreCase(nombreIngresado) &&
							cliente.getContrasena().equalsIgnoreCase(contrasena)) {
						actual = cliente;
					}
				}
				if (actual == null) {
					JOptionPane.showMessageDialog(null, "Lo sentimos, las credenciales ingresadas no corresponden a un Usuario Cliente.");
				} else{
					actual.login(contrasena);
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");

					boolean continuar = true;

					while (continuar) {

						String[] opcionesCliente = {"Jugar", "Ver cuenta", "Solicitar asistencia", "Cargar saldo online","Retirar dinero","Log out"};

						int eleccionMenuCliente = JOptionPane.showOptionDialog(null, "Seleccione una opción",
								"Selección de opción",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesCliente, opcionesCliente[0]);

						if (eleccionMenuCliente == 0) {
							// Acción cuando se selecciona la opcion JUGAR

							int choiceCliente =
									JOptionPane.showOptionDialog(null, "Seleccione un juego", "Juegos",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJuegos,
											opcionesJuegos[0]);
							boolean resultado;


							double apuesta;
							quiereJugar = true;

							switch (choiceCliente) {

								case 0:
									int seguirJugando;
									while (quiereJugar) {


										// Se elige primer juego
										apuesta = Double.parseDouble(JOptionPane.showInputDialog(null,
												"Cuánto desea apostar?"));
										// Llamada al método jugar

										if(actual.jugar(caraOCruz, apuesta)){


										// Generación de resultado
										resultado = juegos.get(0).generarResultado();
										if (resultado) {
											JOptionPane.showMessageDialog(null, "Has ganado " + apuesta * 4 + " pesos!",
													"Ganador",
													JOptionPane.QUESTION_MESSAGE,iconoGano);
										} else {
											JOptionPane.showMessageDialog(null, "Has perdido",
													"Perdedor",
													JOptionPane.QUESTION_MESSAGE,iconoPerdio);
										}
										seguirJugando = JOptionPane.showOptionDialog(null, "Quiere seguir jugando?", "Casino Jocker",
												JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
										if (seguirJugando == 1) {
											JOptionPane.showMessageDialog(null, "Gracias por jugar!",
													"Hasta la proxima!",
													JOptionPane.QUESTION_MESSAGE,iconoGracias);
											quiereJugar = false;
											continuar = false;
										} else {
											choiceCliente = JOptionPane.showOptionDialog(null, "Seleccione un juego", "Juegos",
													JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJuegos,
													opcionesJuegos[0]);
										}
										}
										else{
												JOptionPane.showMessageDialog(null,
														"No tiene saldo suficiente para realizar la apuesta.");
											}
										break;
									}

								case 1:
									// Se elige segundo juego

									while (quiereJugar) {


										// Se elige primer juego
										apuesta = Double.parseDouble(JOptionPane.showInputDialog(null,
												"Cuánto desea apostar?"));
										// Llamada al método jugar

										if(actual.jugar(dados, apuesta)){


											// Generación de resultado
											resultado = juegos.get(1).generarResultado();
										if (resultado) {
											JOptionPane.showMessageDialog(null, "Has ganado " + apuesta * 4 + " pesos!",
													"Ganador",
													JOptionPane.QUESTION_MESSAGE,iconoGano);
										} else {
											JOptionPane.showMessageDialog(null, "Has perdido",
													"Perdedor",
													JOptionPane.QUESTION_MESSAGE,iconoPerdio);
										}
										seguirJugando = JOptionPane.showOptionDialog(null, "Quiere seguir jugando?", "Casino Jocker",
												JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
										if (seguirJugando == 1) {
											JOptionPane.showMessageDialog(null, "Gracias por jugar!",
													"Hasta la proxima!",
													JOptionPane.QUESTION_MESSAGE,iconoGracias);


											quiereJugar = false;

											continuar = false;


										} else {
											choiceCliente = JOptionPane.showOptionDialog(null, "Seleccione un juego", "Juegos",
													JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJuegos,
													opcionesJuegos[0]);
										}}else{
											JOptionPane.showMessageDialog(null,
													"No tiene saldo suficiente para realizar la apuesta.");
										}
										break;
									}
								case 2:

									while (quiereJugar) {


										// Se elige primer juego
										apuesta = Double.parseDouble(JOptionPane.showInputDialog(null,
												"Cuánto desea apostar?"));
										// Llamada al método jugar

										if(actual.jugar(blackjack, apuesta)){


											// Generación de resultado
											resultado = juegos.get(2).generarResultado();
										if (resultado) {
											JOptionPane.showMessageDialog(null, "Has ganado " + apuesta * 4 + " pesos!",
													"Ganador",
													JOptionPane.QUESTION_MESSAGE,iconoGano);
										} else {
											JOptionPane.showMessageDialog(null, "Has perdido",
													"Perdedor",
													JOptionPane.QUESTION_MESSAGE,iconoPerdio);
										}
										seguirJugando = JOptionPane.showOptionDialog(null, "Quiere seguir jugando?",
												"Casino Jocker",
												JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
										if (seguirJugando == 1) {
											JOptionPane.showMessageDialog(null, "Gracias por jugar!",
													"Hasta la proxima!",
													JOptionPane.QUESTION_MESSAGE,iconoGracias);
											quiereJugar = false;
											continuar = false;
										} else {
											choiceCliente = JOptionPane.showOptionDialog(null, "Seleccione un juego", "Juegos",
													JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJuegos,
													opcionesJuegos[0]);
										}}else{
											JOptionPane.showMessageDialog(null,
													"No tiene saldo suficiente para realizar la apuesta.");
										}
										break;
									}
							}
						} else if (eleccionMenuCliente == 1) {
							// Acción cuando se selecciona la opción 2
							JOptionPane.showMessageDialog(null, "Nombre:  " + actual.getNombre() + " Apellido:" + actual.getApellido() +
									" Dinero disponible: $" + actual.getDineroDisponible());
						} else if (eleccionMenuCliente == 2) {
							// Acción cuando se cierra el diálogo sin seleccionar ninguna opción
							actual.solicitarAsistencia();
							JOptionPane.showMessageDialog(null, "En instantes será auxiliado");
						} else if (eleccionMenuCliente == 3) {
							double recarga;
							recarga = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a cargar"));
							actual.cargarSaldoOnline(recarga);
							JOptionPane.showMessageDialog(null, "Su saldo ahora es de $" + actual.getDineroDisponible());
						} else if(eleccionMenuCliente == 4){
							double montoARetirar;
							montoARetirar = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a cargar"));
							if(caja1.getSaldoActual() > montoARetirar && montoARetirar < actual.getDineroDisponible()) {
								actual.retirarDinero(montoARetirar);
								JOptionPane.showMessageDialog(null, "Su saldo ahora es de $" + actual.getDineroDisponible());
							}
							else if (caja2.getSaldoActual() > montoARetirar && montoARetirar < actual.getDineroDisponible()) {
								actual.retirarDinero(montoARetirar);
								JOptionPane.showMessageDialog(null, "Su saldo ahora es de $" + actual.getDineroDisponible());
							}else if(caja3.getSaldoActual() > montoARetirar && montoARetirar < actual.getDineroDisponible()){
								actual.retirarDinero(montoARetirar);
								JOptionPane.showMessageDialog(null, "Su saldo ahora es de $" + actual.getDineroDisponible());
							}else if (montoARetirar > actual.getDineroDisponible()){
								JOptionPane.showMessageDialog(null, "No posee esta cantidad de dinero en su cuenta");
							}else {
								JOptionPane.showMessageDialog(null,
										"No está disponible este monto para retirar, por favor solicite asistencia con un administrador");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Logout Exitoso");
							continuar = false;
						}
					}
				}

				break;

			case 1: //Empleado caja

				EmpleadoCaja empCaja = null;
				for (EmpleadoCaja empleado : empleadosCaja) {
					if (empleado.getNombre().equalsIgnoreCase(nombreIngresado) &&
							empleado.getContrasena().equalsIgnoreCase(contrasena)) {
						empCaja = empleado;
					}
				}

				if (empCaja == null) {

					JOptionPane.showMessageDialog(null,
							"Lo sentimos, las credenciales ingresadas no corresponden a un Usuario Empleado Caja.");

				} else {
					empCaja.login(contrasena);
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");

					boolean continuar = true;

					while (continuar) {

						String[] opcionesECaja = {"Agregar dinero", "Entregar dinero", "Logout"};
						String[] cajasS = {"1", "2", "3", "Regresar"};
						String[] clientesS = {clientes.get(0).getApellido(), clientes.get(1).getApellido(),
								clientes.get(2).getApellido(), clientes.get(3).getApellido(),
								clientes.get(4).getApellido(),
						};

						int eleccionMenuECaja = JOptionPane.showOptionDialog(null, "Seleccione una opción",
								"Empleado caja",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesECaja, opcionesECaja[0]);

						if (eleccionMenuECaja == 0) {
							double monto;
							monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a ingresar"));


							empCaja.agregarDinero(monto);
							JOptionPane.showMessageDialog(null, "Se ha agregado $" + monto + ".");
						} else if (eleccionMenuECaja == 1) {
							double monto;
							monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto a retirar"));

							int clienteAAcreditar;

							clienteAAcreditar = JOptionPane.showOptionDialog(null,
									"Eliga el Nombre del Cliente al que desea entregar el dinero",
									"Seleccione la caja",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, clientesS, clientesS[0]);

							empCaja.entregarDinero(monto, clientes.get(clienteAAcreditar));
							JOptionPane.showMessageDialog(null, "Se ha entregado $" + monto + ".");

						} else {
							JOptionPane.showMessageDialog(null, "Log out exitoso");
							continuar = false;

						}

					}
				}

				break;


			case 2: // Admin

				Administrador adminActual = null;

				for (Administrador admin : administradores) {

					if (admin.getNombre().equalsIgnoreCase(nombreIngresado) &&
							admin.getContrasena().equalsIgnoreCase(contrasena)) {
						adminActual = admin;
					}
				}

				if (adminActual == null) {
					JOptionPane.showMessageDialog(null,
							"Lo sentimos, las credenciales ingresadas no corresponden a un Usuario Administrador.");
				} else if (adminActual instanceof Administrador) {
					adminActual.login(contrasena);
					JOptionPane.showMessageDialog(null,
							"Inicio de sesión exitoso.");

					// CHOICE ADMIN
					boolean continuar = true;

					while (continuar) {

						String[] opcionesAdministrador = {"Caja", "Juego", "Maquina", "Usuario", "Visualizar Cliente", "Logout"};

						int choiceAdministrador =
								JOptionPane.showOptionDialog(null, "Seleccione su Usuario", "Selección de Usuario",
										JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesAdministrador,
										opcionesAdministrador[5]);

						if (choiceAdministrador == 0) {
							JOptionPane.showMessageDialog(null, "Eligió Caja");

							int visualizarCaja = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Caja"));

							boolean encontrado = false;

							for (Caja caja : cajas) {
								if (caja.getIdCaja() == visualizarCaja) {
									encontrado = true;
									admin1.visualizarCaja(caja);
									JOptionPane.showMessageDialog(null, "ID : " + caja.getIdCaja() +
											" | Saldo Inicial: " + caja.getSaldoInicial() + " | Saldo Actual: " + caja.getSaldoActual());
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + visualizarCaja + " no existe.");
							}
						} else if (choiceAdministrador == 1) {
							JOptionPane.showMessageDialog(null, "Eligió Juego");

							String[] opcionesAdministradorJuego = {"Eliminar Juego", "Editar Juego", "Regresar"};
							int choiceAdministradorJuego = JOptionPane.showOptionDialog(null,
									"Seleccione su Usuario", "Selección de Usuario",
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesAdministradorJuego,
									opcionesAdministradorJuego[2]);

							if (choiceAdministradorJuego == 0) {
								JOptionPane.showMessageDialog(null, "Eligió Eliminar Juego");

								String eliminarJuego = JOptionPane.showInputDialog("Ingrese el nombre del juego a eliminar");

								boolean encontrado = false;

								for (Juego juego : juegos) {
									if (juego.getNombre().equalsIgnoreCase(eliminarJuego)) {
										encontrado = true;
										admin1.eliminarJuego(juego, juegos);
										JOptionPane.showMessageDialog(null, "El juego " + eliminarJuego +
												" fue eliminado con éxito.");
										break;
									}
								}

								if (!encontrado) {
									JOptionPane.showMessageDialog(null, "El juego " + eliminarJuego + " no existe.");
								}
							} else if (choiceAdministradorJuego == 1) {
								JOptionPane.showMessageDialog(null, "Eligió Editar Juego");

								String editarJuego = JOptionPane.showInputDialog("Ingrese el nombre del juego a editar");

								boolean encontrado = false;

								for (Juego juego : juegos) {
									if (juego.getNombre().equalsIgnoreCase(editarJuego)) {
										encontrado = true;
										String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del juego");
										String nuevoDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del juego");
										int nuevoJugMin =
												Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de jugadores mínimos del juego"));
										int nuevoJugMax =
												Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de jugadores máximos del juego"));
										admin1.editarJuego(juego, nuevoNombre, nuevoDescripcion, nuevoJugMin, nuevoJugMax);
										JOptionPane.showMessageDialog(null,
												"Los nuevos datos del juego son: \n" + nuevoNombre + " || "
														+ nuevoDescripcion + " || " + nuevoJugMin + " || " + nuevoJugMax);
										break;
									}
								}

								if (!encontrado) {
									JOptionPane.showMessageDialog(null, "El juego " + editarJuego + " no existe.");
								}
							} else if (choiceAdministradorJuego == 2) {
								JOptionPane.showMessageDialog(null, "Eligió Regresar");
							} else {
								JOptionPane.showMessageDialog(null, "Logout exitoso");
								continuar = false;
							}

							
						} else if (choiceAdministrador == 2) {
							JOptionPane.showMessageDialog(null, "Eligió Maquina");

							int visualizarMaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina"));
							boolean encontrado = false;

							for (Maquina maquina : maquinas) {
								if (maquina.getIdMaquina() == visualizarMaquina) {
									encontrado = true;
									admin1.visualizarMaquina(maquina);
									JOptionPane.showMessageDialog(null, "ID: " + maquina.getIdMaquina() +
											" | Saldo de Tickets: " + maquina.getSaldoTickets() + " | Estado Dañada: "
											+ maquina.getDaniada() + " | Estado Habilitado: " + maquina.getHabilitada());
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + visualizarMaquina + " no existe.");
							}
							
							
						} else if (choiceAdministrador == 3) {
							JOptionPane.showMessageDialog(null, "Eligió Usuario");

							int eliminarUsuario =Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID del Usuario a eliminar"));
							boolean encontrado = false;

							for (Usuario usuario : usuarioEjemplo) {
								if (usuario.getIdUsuario() == eliminarUsuario) {
									encontrado = true;
									admin1.eliminarUsuario(usuario, usuarioEjemplo);
									JOptionPane.showMessageDialog(null, "El Usuario con ID "
											+ eliminarUsuario + " fue eliminado con éxito.");
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + eliminarUsuario + " no existe.");
							}
						} else if (choiceAdministrador == 4) {
							JOptionPane.showMessageDialog(null, "Eligió Visualizar Cliente");

							int visualizarCliente =Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID del Cliente"));
							boolean encontrado = false;

							for (Cliente cliente : clientes) {
								if (cliente.getIdCliente() == visualizarCliente) {
									encontrado = true;
									admin1.revisarCuentaCliente(cliente);
									JOptionPane.showMessageDialog(null, "Nombre: " + cliente.getNombre() +
											" | Apellido: " + cliente.getApellido() + " | Fecha de nacimiento: "
											+ cliente.getFecNacimiento() + " | Correo Electrónico: " + cliente.getCorreoElectronico());
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + visualizarCliente + " no existe.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Logout Exitoso");
							continuar = false;

						} 


					}
				}

				break;

			case 3:
				// Empleado maquina
				EmpleadoMaquina empleadoM = null;
				for (EmpleadoMaquina empleado : empleadosMaquina) {
					if (empleado.getNombre().equalsIgnoreCase(nombreIngresado) &&
							empleado.getContrasena().equalsIgnoreCase(contrasena)) {
						empleadoM = empleado;
					}
				}
				boolean continuar = true;
				if (empleadoM == null) {
					JOptionPane.showMessageDialog(null,
							"Lo sentimos, las credenciales ingresadas no corresponden a un Usuario Empleado Máquina.");
				} else {
					empleadoM.login(contrasena);
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");


					while (continuar) {
						String[] opcionesEMaquina = {"Encender Maquina", "Apagar Maquina", "Retirar Tickets", "Recargar Tickets", "Logout"};
						String[] maquinasS = {"Máquina 1", "Máquina 2", "Máquina 3"};

						int eleccionMaquina = JOptionPane.showOptionDialog(null, "Seleccione la máquina en la que quiere trabajar",
								"Empleado Máquina",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, maquinasS, maquinasS[0]);

						int eleccionMenuEMaquina = JOptionPane.showOptionDialog(null, "Seleccione la operación que desea realizar sobre la máquina",
								"Empleado Máquina",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEMaquina, opcionesEMaquina[0]);

						switch (eleccionMenuEMaquina) {

							case 0:
								empleadoM.encenderMaquina(maquinas.get(eleccionMaquina));
								JOptionPane.showMessageDialog(null, "Se ha encendido la máquina.");
								break;
							case 1:
								empleadoM.apagarMaquina(maquinas.get(eleccionMaquina));
								JOptionPane.showMessageDialog(null, "Se ha apagado la máquina.");
								break;
							case 2:
								int cantidadTicketsARetirar;
								cantidadTicketsARetirar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de tickets a retirar"));

								if (maquinas.get(eleccionMaquina).getSaldoTickets() > cantidadTicketsARetirar) {
									empleadoM.retirarTickets(maquinas.get(eleccionMaquina), cantidadTicketsARetirar);
									JOptionPane.showMessageDialog(null, "Se ha retirado " + cantidadTicketsARetirar + " ticket/s" + ".");
								} else {
									JOptionPane.showMessageDialog(null, "No se tienen " + cantidadTicketsARetirar + " ticket/s en esta máquina");
								}
								break;
							case 3:
								int cantidadTicketsARecargar;
								cantidadTicketsARecargar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de tickets a recargar"));

								empleadoM.recargarTickets(maquinas.get(eleccionMaquina), cantidadTicketsARecargar);
								JOptionPane.showMessageDialog(null, "Se ha recargado " + cantidadTicketsARecargar + " ticket/s" + ".");
								break;
							default:
								JOptionPane.showMessageDialog(null, "Log out exitoso");
								continuar = false;
								break;
						}
						;
					}
					;
				}
				break;
			case 4:
				// Tecnico

				Tecnico tec = null;
				continuar = true;
				for (Tecnico tecnico : tecnicos) {
					if (tecnico.getNombre().equalsIgnoreCase(nombreIngresado) &&
							tecnico.getContrasena().equalsIgnoreCase(contrasena)) {
						tec = tecnico;
					}
				}

				if (tec == null) {
					JOptionPane.showMessageDialog(null,
							"Lo sentimos, las credenciales ingresadas no corresponden a un Usuario Empleado Máquina.");
				} else {
					tec.login(contrasena);
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");


					while (continuar) {
						String[] opcionesTecnico = {"Reparar Maquina", "Habilitar Maquina", "Deshabilitar Maquina", "Logout"};
						String[] maquinasS = {"Máquina 1", "Máquina 2", "Máquina 3"};

						int eleccionMaquina = JOptionPane.showOptionDialog(null, "Seleccione la máquina en la que quiere trabajar",
								"Técnico",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, maquinasS, maquinasS[0]);

						int eleccionMenuTecnico = JOptionPane.showOptionDialog(null, "Seleccione la operación que desea realizar sobre la máquina",
								"Empleado Máquina",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTecnico, opcionesTecnico[0]);

						switch (eleccionMenuTecnico) {

							case 0:
								if ((maquinas.get(eleccionMaquina).getDaniada())) {
									tec.repararMaquina(maquinas.get(eleccionMaquina));
									JOptionPane.showMessageDialog(null, "Se ha reparado la máquina.");
								} else {
									JOptionPane.showMessageDialog(null, "No es necesario reparar la máquina.");
								}
								break;
							case 1:
								if ((!maquinas.get(eleccionMaquina).getHabilitada())) {
									tec.habilitarMaquina(maquinas.get(eleccionMaquina));
									JOptionPane.showMessageDialog(null, "Se ha habilitado la máquina.");
								} else {
									JOptionPane.showMessageDialog(null, "La máquina ya está habilitada.");
								}
								break;
							case 2:
								if ((!maquinas.get(eleccionMaquina).getHabilitada())) {
									JOptionPane.showMessageDialog(null, "La máquina ya está deshabilitada.");
								} else {
									tec.deshabilitarMaquina(maquinas.get(eleccionMaquina));
									JOptionPane.showMessageDialog(null, "La máquina fue deshabilitada.");
								}
								break;

							default:
								JOptionPane.showMessageDialog(null, "Log out exitoso");
								continuar = false;
								break;
						}
					}
				}
				break;
		}


}
	}}
