<%@page import="utilitarios.PathCfg"%>
<div class="menu">

        <div class="breadLine">
            <!--<div class="arrow"></div>-->
<!--            <div class="adminControl active">
                Hi, Aqvatarius
            </div>-->
        </div>

<!--        <div class="admin">
            <div class="image">
                <img src="img/users/aqvatarius.jpg" class="img-polaroid"/>
            </div>
            <ul class="control">
                <li><span class="icon-comment"></span> <a href="messages.html">Messages</a> <a href="messages.html" class="caption red">12</a></li>
                <li><span class="icon-cog"></span> <a href="forms.html">Settings</a></li>
                <li><span class="icon-share-alt"></span> <a href="login.html">Logout</a></li>
            </ul>
            <div class="info">
                <span>Welcom back! Your last visit: 24.10.2012 in 19:55</span>
            </div>
        </div>-->

        <ul class="navigation">
            <li class="active">
                <a href="index.jsp">
                    <span class="isw-grid"></span><span class="text">Inicio</span>
                </a>
            </li>
            <li class="">
                <a href="<%=PathCfg.AGENDA_PATH%>">
                    <span class="isw-calendar"></span><span class="text">Agendas</span>
                </a>
            </li>            
            <li>
                <a href='<%= PathCfg.PACIENTES_PATH %>'>
                    <span class="isw-user"></span><span class="text">Pacientes</span>
                </a>
            </li>
            <li>
                <a href="<%= PathCfg.PROFESIONALES_PATH %>">
                    <span class="isw-archive"></span><span class="text">Profesionales</span>
                </a>
            </li>
            <li class="openable">
                <a href="#">
                    <span class="isw-list"></span><span class="text">Administraci&oacute;n</span>
                </a>
                <ul>
                    <li>
                        <a href="<%= PathCfg.ESPECIALIDADES_PATH %>">
                            <span class="icon-th"></span><span class="text">Especialidades</span>
                        </a>
                    </li>
                    <li>
                        <a href="<%= PathCfg.OBRASOCIAL_PATH%>">
                            <span class="icon-th"></span><span class="text">Obras Sociales</span>
                        </a>
                    </li>                       
                </ul>
            </li>            
<!--            <li class="openable">
                <a href="#">
                    <span class="isw-chat"></span><span class="text">Messages</span>
                </a>
                <ul>
                    <li>
                        <a href="messages.html">
                            <span class="icon-comment"></span><span class="text">Messages widgets</span></a>

                            <a href="#" class="caption yellow link_navPopMessages">5</a>

                            <div id="navPopMessages" class="popup" style="display: none;">
                                <div class="head clearfix">
                                    <div class="arrow"></div>
                                    <span class="isw-chats"></span>
                                    <span class="name">Personal messages</span>
                                </div>
                                <div class="body messages">

                                    <div class="item clearfix">
                                        <div class="image"><a href="#"><img src="img/users/aqvatarius.jpg" class="img-polaroid"/></a></div>
                                        <div class="info">
                                            <a href="#" class="name">Aqvatarius</a>
                                            <p>Lorem ipsum dolor. In id adipiscing diam. Sed lobortis dui ut odio tempor blandit. Suspendisse scelerisque mi nec nunc gravida quis mollis lacus dignissim.</p>
                                            <span>19 feb 2012 12:45</span>
                                        </div>
                                    </div>

                                    <div class="item clearfix">
                                        <div class="image"><a href="#"><img src="img/users/olga.jpg" class="img-polaroid"/></a></div>
                                        <div class="info">
                                            <a href="#" class="name">Olga</a>
                                            <p>Cras nec risus dolor, ut tristique neque. Donec mauris sapien, pellentesque at porta id, varius eu tellus.</p>
                                            <span>18 feb 2012 12:45</span>
                                        </div>
                                    </div>

                                    <div class="item clearfix">
                                        <div class="image"><a href="#"><img src="img/users/dmitry.jpg" class="img-polaroid"/></a></div>
                                        <div class="info">
                                            <a href="#" class="name">Dmitry</a>
                                            <p>In id adipiscing diam. Sed lobortis dui ut odio tempor blandit.</p>
                                            <span>17 feb 2012 12:45</span>
                                        </div>
                                    </div>

                                    <div class="item clearfix">
                                        <div class="image"><a href="#"><img src="img/users/helen.jpg" class="img-polaroid"/></a></div>
                                        <div class="info">
                                            <a href="#" class="name">Helen</a>
                                            <p>Sed lobortis dui ut odio tempor blandit. Suspendisse scelerisque mi nec nunc gravida quis mollis lacus dignissim. Donec mauris sapien, pellentesque at porta id, varius eu tellus.</p>
                                            <span>15 feb 2012 12:45</span>
                                        </div>
                                    </div>

                                </div>
                                <div class="footer">
                                    <button class="btn link_navPopMessages" type="button">Close</button>
                                </div>
                            </div>
                    </li>
                </ul>


            </li>
            <li>
                <a href="statistic.html">
                    <span class="isw-graph"></span><span class="text">Statistics</span>
                </a>
            </li>
            <li>
                <a href="tables.html">
                    <span class="isw-text_document"></span><span class="text">Tables</span>
                </a>
            </li>
            <li class="openable">
                <a href="#">
                    <span class="isw-documents"></span><span class="text">Sample pages</span>
                </a>
                <ul>
                    <li>
                        <a href="user.html">
                            <span class="icon-user"></span><span class="text">User profile</span>
                        </a>
                    </li>
                    <li>
                        <a href="users.html">
                            <span class="icon-list"></span><span class="text">Users</span>
                        </a>
                    </li>
                    <li>
                        <a href="stream.html">
                            <span class="icon-refresh"></span><span class="text">Stream activity</span>
                        </a>
                    </li>
                    <li>
                        <a href="mail.html">
                            <span class="icon-envelope"></span><span class="text">Mailbox</span>
                        </a>
                    </li>
                    <li>
                        <a href="edit.html">
                            <span class="icon-pencil"></span><span class="text">User edit</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="openable">
                <a href="#">
                    <span class="isw-zoom"></span><span class="text">Other</span>
                </a>
                <ul>
                    <li>
                        <a href="gallery.html">
                            <span class="icon-picture"></span><span class="text">Gallery</span>
                        </a>
                    </li>
                    <li>
                        <a href="typography.html">
                            <span class="icon-pencil"></span><span class="text">Typography</span>
                        </a>
                    </li>
                    <li>
                        <a href="files.html">
                            <span class="icon-upload"></span><span class="text">File handling</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="openable">
                <a href="#">
                    <span class="isw-cancel"></span><span class="text">Error pages</span>
                </a>
                <ul>
                    <li><a href="403.html"><span class="icon-warning-sign"></span><span class="text">403 Forbidden</span></a></li>
                    <li><a href="404.html"><span class="icon-warning-sign"></span><span class="text">404 Not Found</span></a></li>
                    <li><a href="500.html"><span class="icon-warning-sign"></span><span class="text">500 Internal Server Error</span></a></li>
                    <li><a href="503.html"><span class="icon-warning-sign"></span><span class="text">503 Service Unavailable</span></a></li>
                    <li><a href="504.html"><span class="icon-warning-sign"></span><span class="text">504 Gateway Timeout</span></a></li>
                </ul>
            </li>-->
        </ul>

<!--        <div class="dr"><span></span></div>

        <div class="widget">

            <div class="input-append">
                <input id="appendedInputButton" style="width: 118px;" type="text"><button class="btn" type="button">Search</button>
            </div>

        </div>

        <div class="dr"><span></span></div>

        <div class="widget-fluid">

            <div class="wBlock clearfix">
                <div class="dSpace">
                    <h3>Last visits</h3>
                    <span class="number">6,302</span>
                    <span>5,774 <b>unique</b></span>
                    <span>3,512 <b>returning</b></span>
                </div>
                <div class="rSpace">
                    <h3>Today</h3>
                    <span class="mChartBar" sparkType="bar" sparkBarColor="white">240,234,150,290,310,240,210,400,320,198,250,222,111,240,221,340,250,190</span>
                    <span>&nbsp;</span>
                    <span>65% <b>New</b></span>
                    <span>35% <b>Returning</b></span>
                </div>
            </div>

        </div>-->

    </div>