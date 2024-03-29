IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'server')
	DROP DATABASE [server]
GO

CREATE DATABASE [server]  ON (NAME = N'server', FILENAME = N'C:\Program Files\Microsoft SQL \MSSQL\data\server.mdf' , SIZE = 1, FILEGROWTH = 10%) LOG ON (NAME = N'server_log', FILENAME = N'C:\Program Files\Microsoft SQL \MSSQL\data\server_log.LDF' , FILEGROWTH = 10%)
 COLLATE SQL_Latin1_General_CP1_CI_AS
GO

exec sp_dboption N'server', N'autoclose', N'false'
GO

exec sp_dboption N'server', N'bulkcopy', N'false'
GO

exec sp_dboption N'server', N'trunc. log', N'false'
GO

exec sp_dboption N'server', N'torn page detection', N'true'
GO

exec sp_dboption N'server', N'read only', N'false'
GO

exec sp_dboption N'server', N'dbo use', N'false'
GO

exec sp_dboption N'server', N'single', N'false'
GO

exec sp_dboption N'server', N'autoshrink', N'false'
GO

exec sp_dboption N'server', N'ANSI null default', N'false'
GO

exec sp_dboption N'server', N'recursive triggers', N'false'
GO

exec sp_dboption N'server', N'ANSI nulls', N'false'
GO

exec sp_dboption N'server', N'concat null yields null', N'false'
GO

exec sp_dboption N'server', N'cursor close on commit', N'false'
GO

exec sp_dboption N'server', N'default to local cursor', N'false'
GO

exec sp_dboption N'server', N'quoted identifier', N'false'
GO

exec sp_dboption N'server', N'ANSI warnings', N'false'
GO

exec sp_dboption N'server', N'auto create statistics', N'true'
GO

exec sp_dboption N'server', N'auto update statistics', N'true'
GO

use [server]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Connection]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Connection]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[NodeInformation]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[NodeInformation]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[pda]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[pda]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[possibledelay]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[possibledelay]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[possiblepath]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[possiblepath]
GO




CREATE TABLE [dbo].[Connection] (
	[NodeName] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[Neighbour] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[Cost] [decimal](10, 0) NULL ,
	[Delay] [decimal](18, 0) NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[NodeInformation] (
	[NodeName] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[PortNo] [int] NULL ,
	[SystemName] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL, 
                [Status] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[pda] (
	[path] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[cost] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[delay] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
[node] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL  
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[possibledelay] (
	[destination] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[path] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[delay] [decimal](18, 0) NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[possiblepath] (
	[destination] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[path] [varchar] (20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL ,
	[cost] [decimal](10, 0) NULL ,
	[delay] [decimal](18, 0) NULL 

) ON [PRIMARY]
GO





