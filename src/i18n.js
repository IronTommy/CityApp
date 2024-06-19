import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

i18n.use(initReactI18next).init({
    resources: {
        en: {
            translation: {
                "News": "News",
                "Weather in": "Weather in",
                "Enter city": "Enter city",
                "Temperature": "Temperature",
                "Description": "Description",
                "Humidity": "Humidity",
                "Wind Speed": "Wind Speed",
                "Pressure": "Pressure",
                "Visibility": "Visibility",
                "Forecast for the next days": "Forecast for the next days",
                "Date": "Date"
                // Добавьте другие переводы, если нужно
            }
        },
        ru: {
            translation: {
                "News": "Новости",
                "Weather in": "Погода в",
                "Enter city": "Введите город",
                "Temperature": "Температура",
                "Description": "Описание",
                "Humidity": "Влажность",
                "Wind Speed": "Скорость ветра",
                "Pressure": "Давление",
                "Visibility": "Видимость",
                "Forecast for the next days": "Прогноз на ближайшие дни",
                "Date": "Дата"
                // Добавьте другие переводы, если нужно
            }
        }
    },
    lng: 'en', // Язык по умолчанию
    fallbackLng: 'en',

    interpolation: {
        escapeValue: false // React уже экранирует значения
    }
});

export default i18n;
