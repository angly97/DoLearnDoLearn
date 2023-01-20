import React from "react";
import FullCalendar from "@fullcalendar/react"; // must go before plugins
import dayGridPlugin from "@fullcalendar/daygrid"; // a plugin!

import { SCalendar } from "./styles";

const Calendar = () => {
  const handleEventClick = (arg) => {
    alert(arg.event.title);
  };

  return (
    <SCalendar>
      <FullCalendar
        plugins={[dayGridPlugin]}
        initialView="dayGridMonth"
        events={[
          { title: "살려주세요!!!", date: "2023-01-01" },
          { title: "두런두런은 중소기ㅇ...", date: "2023-01-02" },
          { title: "help", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-10" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-11" },
          { title: "스타트업,,,,,", date: "2023-01-20" },
          { title: "스타트업,,,,,", date: "2023-01-20" },
        ]}
        eventClick={handleEventClick}
        headerToolbar={{
          center: "title",
          left: "today prev next",
          right: "dayGridMonth dayGridWeek dayGridDay",
        }}
      />
    </SCalendar>
  );
};

export default Calendar;