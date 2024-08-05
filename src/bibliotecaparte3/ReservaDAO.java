package bibliotecaparte3;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private static final String FILE_NAME = "reservas.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void salvar(Reserva reserva) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(reserva.getId() + "," + reserva.getIdUsuario() + "," + reserva.getIdObra() + "," + reserva.getDataReserva().format(DATE_FORMAT));
            writer.newLine();
        }
    }

    public void excluir(int id) throws IOException {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("reservas_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                int reservaId = Integer.parseInt(data[0]);
                if (reservaId != id) {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
            
            writer.close();
        }
        tempFile.renameTo(inputFile);
    }

    public void atualizar(Reserva reserva) throws IOException {
        excluir(reserva.getId());
        salvar(reserva);
    }

    public List<Reserva> listar() throws IOException {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                int id = Integer.parseInt(data[0]);
                int idUsuario = Integer.parseInt(data[1]);
                int idObra = Integer.parseInt(data[2]);
                LocalDate dataReserva = LocalDate.parse(data[3], DATE_FORMAT);
                Reserva reserva = new Reserva(id, idUsuario, idObra, dataReserva);
                reservas.add(reserva);
            }
        }
        return reservas;
    }
}