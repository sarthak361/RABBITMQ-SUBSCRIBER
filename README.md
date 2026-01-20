

# Redis vs Kafka vs RabbitMQ
This document explains the differences between Redis, Kafka, and RabbitMQ with real-world use cases.



1. Primary Purpose

Redis is mainly an in-memory data store. Its Pub/Sub feature is used for real-time communication where speed is important, but reliability is not guaranteed.

Kafka is an event streaming platform designed to store and process a continuous stream of events. It is used when event history and replay are required.

RabbitMQ is a message broker designed to handle background tasks and jobs reliably using queues.

2. Communication Model

Redis uses a publisher and subscriber model where messages are published to a channel and delivered only to active subscribers.

Kafka uses a producer and consumer model where producers publish events to topics and consumers read those events using offsets.

RabbitMQ uses producers, exchanges, queues, and consumers. Messages are routed from exchange to queue and then consumed.

3. Message Storage

Redis does not store messages. If a subscriber is offline, the message is lost.

Kafka stores messages in topics for a configured retention time (hours or days).

RabbitMQ stores messages in queues until a consumer consumes and acknowledges them.

4. Consumer Downtime Behavior

If a consumer is offline when a message is sent:

Redis: The message is lost permanently.

Kafka: The message is delivered when the consumer comes back online because it was stored and the offset was not committed.

RabbitMQ: The message is delivered when the consumer comes back online because it was waiting in the queue.

5. After Message Is Consumed

Once a message is consumed:

Redis: There is no tracking or re-delivery.

Kafka: The message is not re-delivered because the offset is committed.

RabbitMQ: The message is deleted from the queue after ACK and cannot be re-delivered.

6. Message Replay

Redis does not support replay.

Kafka supports replay by resetting the consumer offset.

RabbitMQ does not support replay once a message is acknowledged.

7. Delivery Guarantee

Redis does not guarantee delivery.

Kafka provides at-least-once or exactly-once delivery depending on configuration.

RabbitMQ guarantees delivery using acknowledgements.

8. Ordering Guarantee

Redis does not guarantee strict ordering.

Kafka guarantees ordering within a partition.

RabbitMQ guarantees FIFO ordering inside a queue.

9. Scalability

Redis Pub/Sub is limited and not suitable for heavy messaging systems.

Kafka is highly scalable and can handle millions of messages per second.

RabbitMQ scales well for job queues but is not designed for massive event streaming.

10. Real-World Use Cases (Project Based)

Redis:

Real-time notifications

Cache invalidation events

Live updates

Kafka:

Order lifecycle events

Payment and transaction events

Event logging and analytics

RabbitMQ:

Order processing

Email and SMS sending

Background job execution

Payment retries

