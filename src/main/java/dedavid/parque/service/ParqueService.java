package dedavid.parque.service;

import dedavid.parque.models.Desconto;
import dedavid.parque.models.Passaporte;
import dedavid.parque.repository.DescontoRepository;
import dedavid.parque.repository.PassaporteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class ParqueService {

    private PassaporteRepository passaporteRepository;
    private DescontoRepository descontoRepository;
    private int entrada = 0;

    public ParqueService(PassaporteRepository passaporteRepository, DescontoRepository descontoRepository) {
        this.passaporteRepository = passaporteRepository;
        this.descontoRepository = descontoRepository;
    }

    public List<Passaporte> getPassaportes() {
        return passaporteRepository.findAll();

    }

    public Passaporte getPassaporte(long id) {
        return passaporteRepository.findById(id).orElse(null);
    }

    public Passaporte criarPassaporte(Passaporte novoPassaporte, List<Desconto> descontos) {
        BigDecimal valorbasico = novoPassaporte.getValorBasico();
        int dias = novoPassaporte.getNroDias();
        BigDecimal valorDias = valorbasico.multiply(BigDecimal.valueOf(dias));
        BigDecimal totalDescontos = new BigDecimal("0");
        BigDecimal cemPorCento = new BigDecimal("100");

        for (Desconto desconto : descontos) {
            totalDescontos = desconto.getValor();
        }

        BigDecimal valorFinal = (valorDias.subtract(totalDescontos)).divide(cemPorCento, RoundingMode.UP);

        if (valorFinal.compareTo(new BigDecimal(0)) > 0) {
            novoPassaporte.setValorTotal(valorFinal);
        } else throw new IllegalArgumentException("Valor não permitido");

        return passaporteRepository.save(novoPassaporte);
    }

    public void registrarEntrada(long id) {
        Passaporte passRegistraDias = getPassaporte(id);

        if (isEntradaValida(id)) {
            entrada++;
            passRegistraDias.setNroEntradas(entrada);
        }

        passaporteRepository.save(passRegistraDias);
    }

    private boolean isEntradaValida(long id) {
        LocalDate dataInicio = getPassaporte(id).getDataInicial();
        int dias = getPassaporte(id).getNroDias();

        //antes de hoje ou depois dos dias
        return !dataInicio.isBefore(LocalDate.now()) && !dataInicio.isAfter(LocalDate.now().plusDays(dias));
    }

    public List<Desconto> getDescontos() {
        return descontoRepository.findAll();
    }

    public Desconto getDesconto(long id) {
        return descontoRepository.findById(id).orElse(null);
    }

    public Desconto criarDesconto(Desconto desconto) {
       return descontoRepository.save(desconto);
    }

    public void ativarDesconto(long id, boolean ativar) {
        Desconto ativo = getDesconto(id);
        ativo.setAtivo(ativar);
        descontoRepository.save(ativo);
    }
}
