package repositorio;

import consultas.Consul1;
import consultas.Consul2;
import consultas.Consul3;
import consultas.Consul4;
import consultas.Consul5;
import java.util.List;

public interface RepositorioConsultas {
    public List<Consul1> Consulta1();
    public List<Consul2> Consulta2();
    public List<Consul3> Consulta3();
    public List<Consul4> Consulta4();
    public List<Consul5> Consulta5();
}
