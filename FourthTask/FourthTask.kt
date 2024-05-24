fun main() {
    val newsPoster = NewsPoster()

    val emailSubscriber = EmailSubscriber("k.putyatin02@gmail.com")
    val smsSubscriber = SmsSubscriber("7-937-635-84-05")
    val appSubscriber = AppSubscriber("testUser")

    newsPoster.subscribe(emailSubscriber)
    newsPoster.subscribe(smsSubscriber)
    newsPoster.subscribe(appSubscriber)

    newsPoster.postNews("Срочные новости: Тестовое здание!")

    newsPoster.unsubscribe(smsSubscriber)

    newsPoster.postNews("Обновление: Тестовое задание!")
}

//Интерфейс, который будет исрользоваться subscribers
interface Subscriber {
    fun update(news: String)
}

//Класс, который будет оповещать subscribers
class NewsPoster {
    private val subscribers = mutableListOf<Subscriber>()

    fun subscribe(subscriber: Subscriber) {
        subscribers.add(subscriber)
    }

    fun unsubscribe(subscriber: Subscriber) {
        subscribers.remove(subscriber)
    }

    fun notifySubscribers(news: String) {
        for (subscriber in subscribers) {
            subscriber.update(news)
        }
    }

    fun postNews(news: String) {
        println("Новость: $news")
        notifySubscribers(news)
    }
}

//Несколько классов subscriber
class EmailSubscriber(private val email: String) : Subscriber {
    override fun update(news: String) {
        println("Новости отправлены $email: $news")
    }
}

class SmsSubscriber(private val phoneNumber: String) : Subscriber {
    override fun update(news: String) {
        println("Новости отправлены $phoneNumber: $news")
    }
}

class AppSubscriber(private val username: String) : Subscriber {
    override fun update(news: String) {
        println("Оповещение $username в приложении: $news")
    }
}
