+++
title = "Apache ShardingSphere：由开源驱动的分布式数据库中间件生态"
weight = 18
chapter = true
+++

# Apache ShardingSphere：由开源驱动的分布式数据库中间件生态

2021 年 7 月 21 日 2021 亚马逊云科技中国峰会现场，SphereEx 联合创始人、Apache ShardingSphere PMC 潘娟受邀参与此次峰会，以《Apache ShardingSphere 分布式数据库中间件开源生态构建》为主题，围绕开源理念扩散、社区建设、ShardingSphere 如何践行 Apache Way 等方面展开了介绍，本文总结自潘娟内容分享。

## 在数据库之上与业务之下的新生态
**一层贴近应用，一层贴近 DataBase。**

不同的行业、不同的用户、不同的定位、不同的需求....如今的数据库面临着比过去更加复杂的数据应用场景以及愈发个性化和定制化的数据处理需求。愈发苛刻的生产环境，也在推动着不同的数据库不断将数据读写速度、延时、吞吐量等性能指标发挥到极致。

久而久之，分工明确的数据应用场景逐渐导致了数据库市场的碎片化，且难以出现一款能够完美适配所有场景的数据库。在不同的业务场景下选择不同的数据库，已经成为一种常见的企业选型方法。

但同样，这种百花齐放的数据库形态，也会带来『百花齐放』的问题。但从宏观的角度来看，这些问题之间是存在共性的，是可以被抽离出来并形成一套事实标准的。如果能够在这些百花齐放的数据库之上构建能够统一应用管理数据的平台层，就可以在屏蔽底层数据库差异的前提下，按照固定标准来进行开发，这种标准化解决方案将会极大缩减用户管理基础数据设施的压力和学习成本。

Apache ShardingSphere 就是位于这一层，通过复用原有数据库的能力，能够帮助技术团队在此之上实现如分片、加密解密等增量能力的开发，且向下不需考虑底层数据库的配置，向上又能够屏蔽用户感知，从而快速构建起面向业务的数据库直连能力，轻松管理大规模的数据集群。

## 如何践行 Apache Way
**1.Sharding**

**ShardingSphere 可同时叠加使用多个功能来满足用户的多样化需求。**

随着业务体量的增大，单体数据库难以支撑大体量业务时，就有必要对数据库进行横向扩展，这就必然要面临着分布式管理的问题。ShardingSphere 通过在数据库之上构建一层热插拔功能层，并提供传统数据库的操作模式，屏蔽使用者对底层数据库变化的感知，赋予开发者使用单体数据库的方式来管理大规模数据库集群的能力。其中，ShardingSphere 主要包含以下四种应用场景：

* Sharding 策略

业务体量增大时，所面临的数据分片压力就会随之增加，所对应的分片策略相应就会被设计的更加复杂。ShardingSphere 能够以灵活、易扩展的方式，以最低成本协助用户在原本水平扩展之外做更多的分片策略，同时也支持自定义扩展的能力。

* 读写分离

通常情况下实现主从部署能够有效缓解数据库的压力，但如果某一个集群下的机器或库表出现问题，无法进行正常读写操作，就会对业务造成比较大的影响。为避免业务不可用，通常需要开发者重新写一套高可用的策略来实现读写库表的主从切换。ShardingSphere 可以自动探索所有集群的状态，在第一时间发现请求不可靠、底层数据库发生主从切换等问题，并可以在表层用户没有产生感知的前提下自动恢复主从状态。

* Sharding Scaling

随着业务的增长，可能会需要对此前拆分过的数据集群进行再一次拆分。ShardingSphere 配套的 Scaling 组件，只需一条 SQL 命令就可以启动任务，并在后台实时展示运行状态。通过 Scaling 这种『管道』，使旧的数据库生态和新的数据库生态重新连接起来。

* 数据加解密

在数据库的应用中，对于关键数据的加解密也是非常重要的一部分。如果原有系统监控能力不达标，部分敏感数据可能是以明文的状态存储的，后期需要对其进行加密处理，这是许多团队普遍存在的问题。ShardingSphere 通过对这部分能力进行标准化并集成在中间件生态上，自动化用户对新、旧业务的数据脱敏以及加解密的过程，整个过程实现了用户层面的无感知。同时支持多种内置的数据加解密/脱敏算法，用户也可根据自身情况来自定义扩展相应的数据算法。

**2.构造数据的接入神经：可插拔的 Database Plus 平台**

面对各种各样的需求以及使用场景，ShardingSphere 为不同领域的开发者提供了面向 Java 的 JDBC、面向异构的代理端以及面向上云的 Sidecar 端这三种接入形式，用户可以按具体需求来做选型，在原有集群之上来做分片、读写分离、数据迁移等相关操作。

* **JDBC 接入：**完全以 JDBC 的方式去使用，可以理解为一款增强的 JDBC 驱动程序，完全兼容 JDBC 和各种 ORM 框架，不需额外的部署和依赖即能够实现分布式管理、水平拓展、脱敏等一系列操作；

* **Proxy 接入：**以模拟数据库服务的形式，通过 Proxy 来管理底层真实的数据库集群，基本无需对业务进行改造；

* **云上 mesh 接入：**为 ShardingSphere 提供公有云上的部署形式。在云上，目前 SphereEx 已经加入了亚马逊云科技的云创计划，后续会在中国区和海外陆续在 Marketplace 与亚马逊云科技展开深度合作，为亚马逊云科技上的用户提供更加强大的 Proxy 镜像部署能力，共同为企业应用打造更加成熟的云上环境。



## 开源，让个人工作连接到世界
ShardingSphere 从开源至今，已经在业内产生了相当的影响力，目前国内只要涉及到水平扩展方面的工具或能力时，通常 ShardingSphere 都会出现在候选名单中。这一点当然有项目维护团队成年累月的贡献，使 ShardingSphere 的功能愈发完善，另一方面也归功于国内日益向上的开源氛围。

过去几年在开源社区上，国内用户大多是扮演程序下载和代码引用的角色，在社区建设方面却少有涉及。最近几年随着开源理念在国内的推广，开始涌现出越来越多抱有很强技术情怀的同学，正是有这些同学的加入，才能让 ShardingSphere 的社区越来越活跃。**因为对于一个好的开源项目而言，评判标准并非只是其理念超前、技术先进等，更多是在技术影响力、开源影响力、生态建设、开发者群体等多方面所积攒的深厚基础。**

这也是为什么 ShardingSphere 作为一款 Apache 顶级开源项目，依然在积极号召大家参与到开源社区中来。毕竟大家每天接触到的只是身边这群人，所做的工作也只是办公室里的这些事，每天被『局限』在这个圈子中。而通过开源，则可以让自己的工作连接到世界，让自己能够抛开书本真正投入到项目中来，打开视野，逐渐培养开放、合作的精神，重新发现自己当下所产生的价值。