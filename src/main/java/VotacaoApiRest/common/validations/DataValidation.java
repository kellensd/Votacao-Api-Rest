package VotacaoApiRest.common.validations;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataValidation {

    public static boolean isDatasDaMesmaSemana(LocalDate localDateBanco, LocalDate localDateDaVotacaoAtual) {
        Date dataBanco = converteLocalDateParaDate(localDateBanco);
        Date dataDaVotacaoAtual = converteLocalDateParaDate(localDateDaVotacaoAtual);
        Date primeiroDiaDaSemanaDataBanco = getPrimeiroOuUltimoDiaDaSemana(dataBanco, true);
        Date ultimoDiaDaSemanaDataBanco = getPrimeiroOuUltimoDiaDaSemana(dataBanco, false);

        Date primeiroDiaDaSemanaDataDaVotacaoAtual = getPrimeiroOuUltimoDiaDaSemana(dataDaVotacaoAtual, true);
        Date ultimoDiaDaSemanaDataDaVotacaoAtual = getPrimeiroOuUltimoDiaDaSemana(dataDaVotacaoAtual, false);

        String semanaDataBanco = getDataPadraoDdMmYyyy(primeiroDiaDaSemanaDataBanco) + " - "
                + getDataPadraoDdMmYyyy(ultimoDiaDaSemanaDataBanco);
        String semanaDataDaVotacaoAtual = getDataPadraoDdMmYyyy(primeiroDiaDaSemanaDataDaVotacaoAtual) + " - "
                + getDataPadraoDdMmYyyy(ultimoDiaDaSemanaDataDaVotacaoAtual);

        if (semanaDataBanco.equalsIgnoreCase(semanaDataDaVotacaoAtual)) {
            return true;
        }
        return false;
    }

    private static Date getPrimeiroOuUltimoDiaDaSemana(Date data, boolean isPrimeiro) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(data);
        if (isPrimeiro)
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        else
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    public static boolean isDatasIguais(LocalDate localDateBanco, LocalDate localDateDaVotacaoAtual) {
        Date dataBanco = converteLocalDateParaDate(localDateBanco);
        Date dataDaVotacaoAtual = converteLocalDateParaDate(localDateDaVotacaoAtual);
        return dataBanco.equals(dataDaVotacaoAtual);
    }

    public static String getDataPadraoDdMmYyyy(Date data) {
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        return formatar.format(data);
    }

    public static Date converteLocalDateParaDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}