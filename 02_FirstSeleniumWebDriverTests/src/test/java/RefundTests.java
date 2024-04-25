import org.junit.Assert;
import org.junit.Test;
public class RefundTests {
    /* Функция расчёта процента при возврате билета

Составьте не менее пяти тест-кейсов для этой функции.
Опирайтесь в первую очередь на аналитику, примените привычные вам техники тест-дизайна.
Оформите сценарии в виде автотестов JUnit.
В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия,
посетитель имеет право при возврате билета:

За 10 и более дней — получить обратно полную стоимость билета.
От 6 до 10 дней включительно — получить 50% стоимости билета.
От 3 до 5 дней включительно — получить 30% стоимости билета.
За 72 часа и менее до начала концерта — стоимость билета не возвращается.
*/




        @Test
        public void Refund100_1() {

            var actualResult = getRefundTicketPricePercent ( 240, false, false );
            Assert.assertEquals ( (Integer) 100, actualResult );
        }

        @Test
        public void Refund100_2() {

            var actualResult = getRefundTicketPricePercent ( 264, false, false );
            Assert.assertEquals ( (Integer) 100, actualResult );
        }

        @Test
        public void Refund50() {

            var actualResult = getRefundTicketPricePercent ( 144, false, false );
            Assert.assertEquals ( (Integer) 50, actualResult );
        }

        @Test
        public void Refund30_1() {

            var actualResult = getRefundTicketPricePercent ( 72, false, false );
            Assert.assertEquals ( (Integer) 30, actualResult );
        }

        @Test
        public void Refund30_2() {

            var actualResult = getRefundTicketPricePercent ( 120, false, false );
            Assert.assertEquals ( (Integer) 30, actualResult );
        }

        @Test
        public void Refund0() {

            var actualResult = getRefundTicketPricePercent ( 65, false, false );
            Assert.assertEquals ( (Integer) 0, actualResult );
        }

        private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
            if (wasConcertCancelled && wasConcertRescheduled) return 100;

            if (hoursBeforeConcert > 240) return 100;

            if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;

            if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;

            return 0;
        }
    }

