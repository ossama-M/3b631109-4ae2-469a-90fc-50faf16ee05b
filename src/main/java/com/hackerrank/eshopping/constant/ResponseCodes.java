package com.hackerrank.eshopping.constant;



import com.hackerrank.eshopping.util.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ResponseCodes {

    @Value(Value = "عملية ناجحة")
    public static final int SUCCESS = 200;

    @Value(Value = "عملية ناجحة")
    public static final int AFTER_PAYMENT_TRANS_SUCCESS = 201;

    @Value(Value = "تم إلغاء المعاملة بناء على رفض البنك")
    public static final int AFTER_PAYMENT_TRANS_CANCELED = 201;

    @Value(Value = "تم إلغاء الحركة")
    public static final int REVERSAL_TRANS = 201;

    @Value(Value = "المخبز غير موجود")
    public static final int BAKERY_NOT_FOUND = 300;

    @Value(Value = "المخبز موقوف")
    public static final int BAKERY_INACTIVE = 301;

    @Value(Value = "الماكينة غير موجودة")
    public static final int POS_NOT_FOUND = 302;

    @Value(Value = "الماكينة غير مفعلة")
    public static final int POS_INACITVE = 303;

    @Value(Value = "الماكينة غير مربوطة بالمخبز")
    public static final int POS_NOT_ASSOCIATED_WITH_BAKERY = 304;

    @Value(Value = "عدد الأرغفة المطلوبة أكثر من المتاح فى المخبز")
    public static final int NO_OF_LOAFS_GREATER_THAN_AVILABLE = 305;

    @Value(Value = "عدد الأرغفة المطلوبة أكثر من ")
    public static final int NO_OF_LOAFS_GREATER_THAN_MAX_PER_DAY = 306;

    @Value(Value = "يوجد أكثر من عملية معلقة للبطاقة")
    public static final int CARD_HAS_PENDING_PURCHASE = 307;

    @Value(Value = "تم أستنفاذ عمليات الشراء للبطاقة لهذا اليوم")
    public static final int CARD_CONFIRMED_TRANS_GREATER_THAN_OR_EQUAL_MAX_TRANS_PER_CURRENT_DAY = 308;

    @Value(Value = "الكمية المطلوبة أكبر من الكمية المتاحة للبطاقة فى اليوم")
    public static final int LOAF_QUANTITY_GREATER_THAN_MAX_LOAF_QUANTITY_PER_DAY = 309;

    @Value(Value = "المخبز غير مسجل فى منظومة الصرف بالسعر الحر")
    public static final int BAKERY_IS_NOT_ALLOWED_TO_USE_FREE_PRICE_SERVICE = 310;

    @Value(Value = "سعر الرغيف غير صحيح")
    public static final int WRONG_LOAF_PRICE = 311;

    @Value(Value = "قيمة المعاملة غير صحيحة")
    public static final int WRONG_LOAF_AMOUNT = 312;

    @Value(Value = "سيريال الماكينة غير صحيح")
    public static final int WRONG_POS_SERIAL = 313;

    @Value(Value = "عدد الأرغفة غير صحيح")
    public static final int WRONG_LOAF_QUANTITY = 314;

    @Value(Value = "غير مسموح بالعمل خارج الساعات المحددة للمخبز")
    public static final int WORKING_TIME_VIOLATION = 315;

    @Value(Value = "تم تجاوز الحد الاقصى من التأمين")
    public static final int NO_OF_LOAFS_GREATER_THAN_REMAINING = 316;

    @Value(Value = "تم أستنفاذ حصة العيش الحر للمخبز اليوم")
    public static final int PERCENTAGE_OF_FREE_BREAD_IN_DAY_ALREADY_SOLD = 317;

    @Value(Value = "لا يوجد حصة تأمينية للمخبز")
    public static final int BAKERY_NOT_HAVE_INSURANCE = 318;

    @Value(Value = "عدد الأرغفة المطلوبة أكثر من المحدد للمعاملة")
    public static final int LOAF_QUANTITY_GREATER_THAN_MAX_QUANTITY_PER_TRANS = 319;

    @Value(Value = "الكمية المطلوبة أكثر من حصة العيش الحر")
    public static final int LOAF_QUANTITY_GREATER_THAN_REMAINING_FREE_BREAD_QUANTITY = 320;
    @Value(Value = "لا يوجد مخابز مسجله في منظومة العيش الحر")
    public static final int FB_BAKERIES_NOT_FOUND = 321;

    @Value(Value = "حدث خطأ أثناء التنفيذ")
    public static final int UNHANDELED_EXCEPTION = 500;

    @Value(Value = "حدث خطأ أثناء التنفيذ")
    public static final int DUPLICATED_TRANS = 501;

    @Value(Value = "حدث خطأ فى الاتصال")
    public static final int DB_TIMEOUT = 502;

    @Value(Value = "حدث خطأ أثناء التنفيذ")
    public static final int ROLLBACK_TRANS_CONFIRMATION = 503;

    @Value(Value = "حدث خطأ أثناء التنفيذ")
    public static final int ROLLBACK_TRANS_CANCELATION = 504;




    public static String getDesc(int constantValue) {
        String Desc = "";
        Field[] interfaceFields = ResponseCodes.class.getFields();
        for (Field f : interfaceFields) {
            try {
                if (Integer.valueOf(f.get(null).toString()) == constantValue) {
                    Annotation annotation = f.getAnnotation(Value.class);
                    if (annotation instanceof Value) {
                        Value objValue = (Value) annotation;
                        Desc = objValue.Value();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Desc;

    }

}

