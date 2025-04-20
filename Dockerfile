# نستخدم صورة جاهزة من جافا JDK 17
FROM openjdk:17

# نسخ ملف جافا من جهازك إلى مجلد /app داخل الحاوية
COPY App.java /app/

# تغيير المجلد إلى /app
WORKDIR /app

# ترجمة كود جافا إلى ملف .class
RUN javac App.java

# تشغيل البرنامج عند تشغيل الحاوية
CMD ["java", "App"]

