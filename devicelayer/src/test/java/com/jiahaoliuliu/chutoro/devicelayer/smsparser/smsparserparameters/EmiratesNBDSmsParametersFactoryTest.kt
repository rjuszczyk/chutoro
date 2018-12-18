package com.jiahaoliuliu.chutoro.devicelayer.smsparser.smsparserparameters

import com.jiahaoliuliu.chutoro.devicelayer.smsparser.Sms
import com.jiahaoliuliu.chutoro.devicelayer.smsparser.SmsParserHelper
import com.jiahaoliuliu.chutoro.entity.Source
import com.jiahaoliuliu.chutoro.entity.TransactionBuilder
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * This is a test against the sms patterns in the factory. More than a unit test
 * this is the core system test test
 */
@RunWith(MockitoJUnitRunner::class)
class EmiratesNBDSmsParametersFactoryTest {

    companion object {
        private val SOURCE = Source.EmiratesNBD.toString()

        // Pattern 1
        private val PATTERN_1_SMS_ID: Long = 6543
        private val PATTERN_1_SMS_QUANTITY = 2675
        private val PATTERN_1_SMS_DATE = 1543522832854L
        private val PATTERN_1_SMS_CURRENCY = "AED"
        private val PATTERN_1_SMS_DESTINATION = "ZOOM SITE 6562 BURJ AL SA, DUBAI"
        private val PATTERN_1_SMS_BODY = "Purchase of AED 26.75 with Debit Card ending 6819 at ZOOM SITE 6562 BURJ AL SA, DUBAI. Avl Balance is AED 54,520.42."

    }

    private val emiratesNBDParametersFactory = EmiratesNBDParametersFactory()
    private val smsParserHelper: SmsParserHelper = SmsParserHelper()

    @Before
    fun setup() {
    }

    @Test
    fun testPattern1() {
        // Prepare the data
        val sms = Sms(PATTERN_1_SMS_ID, PATTERN_1_SMS_BODY, PATTERN_1_SMS_DATE)

        // Execute the method
        val transaction = smsParserHelper.parseSmsToTransaction(sms,
                emiratesNBDParametersFactory.createSmsParserParametersList())

        // Verify the results
        assertNotNull(transaction)
        val rightTransaction = TransactionBuilder()
                .setSmsId(PATTERN_1_SMS_ID)
                .setQuantity(PATTERN_1_SMS_QUANTITY)
                .setCurrency(PATTERN_1_SMS_CURRENCY)
                .setSource(SOURCE)
                .setDestination(PATTERN_1_SMS_DESTINATION)
                .setDate(PATTERN_1_SMS_DATE)
                .build()

        assertEquals(rightTransaction, transaction)
    }

//    @Test
//    fun testPattern1_OtherCurrency() {
//        // Prepare the data
//        val sms = Sms(PATTERN_1_CURRENCY_SMS_ID, PATTERN_1_CURRENCY_SMS_BODY,
//                PATTERN_1_CURRENCY_SMS_DATE)
//
//        // Execute the method
//        val transactionList = smsParserHelper.mapSmsListToTransactionsList(
//                Arrays.asList(sms),
//                hsbcSmsParametersFactory.createSmsParserParametersList())
//
//        // Verify the results
//        assertEquals(1, transactionList.size.toLong())
//        val rightTransaction = TransactionBuilder()
//                .setSmsId(PATTERN_1_CURRENCY_SMS_ID)
//                .setQuantity(PATTERN_1_CURRENCY_SMS_QUANTITY)
//                .setCurrency(PATTERN_1_CURRENCY_SMS_CURRENCY)
//                .setSource(SOURCE)
//                .setDestination(PATTERN_1_CURRENCY_SMS_DESTINATION)
//                .setDate(PATTERN_1_CURRENCY_SMS_DATE)
//                .build()
//
//        assertEquals(rightTransaction, transactionList[0])
//    }

//    @Test
//    fun testPattern2() {
//        // Prepare the data
//        val sms = Sms(PATTERN_2_SMS_ID, PATTERN_2_SMS_BODY, PATTERN_2_SMS_DATE)
//
//        // Execute the method
//        val transactionList = smsParserHelper.mapSmsListToTransactionsList(
//                Arrays.asList(sms),
//                hsbcSmsParametersFactory.createSmsParserParametersList())
//
//        // Verify the results
//        assertEquals(1, transactionList.size.toLong())
//        val rightTransaction = TransactionBuilder()
//                .setSmsId(PATTERN_2_SMS_ID)
//                .setQuantity(PATTERN_2_SMS_QUANTITY)
//                .setCurrency(PATTERN_2_SMS_CURRENCY)
//                .setSource(SOURCE)
//                .setDestination(PATTERN_2_SMS_DESTINATION)
//                .setDate(PATTERN_2_SMS_DATE)
//                .build()
//
//        assertEquals(rightTransaction, transactionList[0])
//    }

}
