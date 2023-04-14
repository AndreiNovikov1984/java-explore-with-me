# java-explore-with-me
В рамках дипломного проекта я разработал приложение ExploreWithMe (англ. «исследуй со мной»). Оно позволит пользователям делиться информацией об интересных событиях и находить компанию для участия в них.

**Модель данных**
- Жизненный цикл события должен включать несколько этапов:
1. Создание.
2. Ожидание публикации. В статус ожидания публикации событие переходит сразу после создания.
3. Публикация. В это состояние событие переводит администратор.
4. Отмена публикации. В это состояние событие переходит в двух случаях. Первый — если администратор решил, что его нельзя публиковать. Второй — когда инициатор события решил отменить его на этапе ожидания публикации.

https://github.com/AndreiNovikov1984/java-explore-with-me/pull/6
